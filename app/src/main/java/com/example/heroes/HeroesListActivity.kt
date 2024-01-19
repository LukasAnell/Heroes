package com.example.heroes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesday1.R
import com.example.heroesday1.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesListBinding
    private lateinit var heroList: List<Hero>

    companion object {
        const val TAG = "HeroesListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Heroes"
        loadJSON()
        Log.d(TAG, "heroList: $heroList")
        refreshList()
    }

    private fun refreshList() {
        val heroAdapter = HeroAdapter(heroList)

        val recyclerView: RecyclerView = binding.recyclerViewHeroesListHeroes
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = heroAdapter
    }

    private fun sortByName() {
        heroList = heroList.sortedBy { it.name }
    }

    private fun sortByRanking() {
        heroList = heroList.sortedBy { it.ranking }
    }

    private fun sortByDescription() {
        heroList = heroList.sortedBy { it.description }
    }

    private fun loadJSON() {
        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val sType = object: TypeToken<List<Hero>>() { }.type
        val otherList = gson.fromJson<List<Hero>>(jsonString, sType) .sortedBy { it.ranking }

        heroList = otherList
    }

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.sorting_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.menu_item_sortByName -> {
                sortByName()
                refreshList()
                true
            }
            R.id.menu_item_sortByRanking -> {
                sortByRanking()
                refreshList()
                true
            }
            R.id.menu_item_sortByDescriptionLength -> {
                sortByDescription()
                refreshList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}