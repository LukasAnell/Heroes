package com.example.heroesday1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroesday1.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesDetailBinding

    companion object {
        const val TAG = "HeroesDetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_detail)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}