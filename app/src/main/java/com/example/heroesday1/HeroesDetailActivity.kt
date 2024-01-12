package com.example.heroesday1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val name = intent.getStringExtra("name") ?: ""
        val description = intent.getStringExtra("description") ?: ""
        val superpower = intent.getStringExtra("superpower") ?: ""
        val ranking = intent.getStringExtra("ranking") ?: ""
        val image = intent.getStringExtra("image") ?: ""

        binding.textViewHeroesDetailName.setText(if(name != "null") name else "")
        binding.textViewHeroesDetailDescription.setText(if(description != "null") description else "")
        binding.textViewHeroesDetailSuperpower.setText(if(superpower != "null") superpower else "")
        binding.textViewHeroesDetailRanking.setText(if(ranking != "null") ranking else "")
        binding.imageViewHeroesDetailImage.setImageResource(resources.getIdentifier(image, "drawable", packageName))

        binding.buttonHeroesDetailBack.setOnClickListener {
            val intent = Intent(this, HeroesListActivity::class.java)
            startActivity(intent)
        }
    }
}