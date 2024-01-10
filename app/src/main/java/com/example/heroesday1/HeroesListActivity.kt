package com.example.heroesday1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.heroesday1.databinding.ActivityHeroesListBinding
import com.google.gson.Gson

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
    }

    private fun loadJSON() {
        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val sType = object: com.google.gson.reflect.TypeToken<List<Hero>>() { }.type
        val otherList = gson.fromJson<List<Hero>>(jsonString, sType)

        heroList = otherList
    }
}