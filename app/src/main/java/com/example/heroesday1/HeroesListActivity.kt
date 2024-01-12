package com.example.heroesday1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        setContentView(R.layout.activity_heroes_list)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadJSON()
        Log.d(TAG, "heroList: $heroList")

        // sortHeroes()

        val heroAdapter = HeroAdapter(heroList)

        val recyclerView: RecyclerView = binding.recyclerViewHeroesListHeroes
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = heroAdapter
    }

    private fun sortHeroes() {
        heroList = heroList.sortedBy { it.ranking }
    }

    private fun loadJSON() {
        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val sType = object: TypeToken<List<Hero>>() { }.type
        val otherList = gson.fromJson<List<Hero>>(jsonString, sType)

        heroList = otherList
    }
}