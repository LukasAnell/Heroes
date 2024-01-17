package com.example.heroesday1

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.heroesday1.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesDetailBinding

    companion object {
        const val TAG = "HeroesDetailActivity"
        val EXTRA_HERO = "hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)
        val name = hero?.name
        val description = hero?.description
        val superpower = hero?.superpower
        val ranking = hero?.ranking.toString()
        val image = hero?.image

        binding.textViewHeroesDetailName.text = if(name != "null") name else ""
        binding.textViewHeroesDetailDescription.text = if(description != "null") description else ""
        binding.textViewHeroesDetailSuperpower.text = if(superpower != "null") superpower else ""
        binding.textViewHeroesDetailRanking.text = if(ranking != "null") ranking else ""
        binding.imageViewHeroesDetailImage.setImageResource(resources.getIdentifier(image, "drawable", packageName))

        binding.buttonHeroesDetailBack.setOnClickListener {
            val intent = Intent(this, HeroesListActivity::class.java)
            startActivity(intent)
        }
    }
}