package com.example.heroesday1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(private val heroList: List<Hero>): RecyclerView.Adapter<HeroAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val superpowerTextView: TextView = view.findViewById(R.id.superpowerTextView)
        val rankingTextView: TextView = view.findViewById(R.id.rankingTextView)
        val heroImageView: ImageView = view.findViewById(R.id.heroImageView)

        init {
            nameTextView = view.findViewById(R.id.nameTextView)
            descriptionTextView = view.findViewById(R.id.descriptionTextView)
            superpowerTextView = view.findViewById(R.id.superpowerTextView)
            rankingTextView = view.findViewById(R.id.rankingTextView)
            heroImageView = view.findViewById(R.id.heroImageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.hero_list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val hero = heroList[position]
        viewHolder.nameTextView.text = hero.name
        viewHolder.descriptionTextView.text = hero.description
        viewHolder.superpowerTextView.text = hero.superpower
        viewHolder.rankingTextView.text = hero.ranking.toString()
        viewHolder.heroImageView.setImageResource(hero.image)
    }
}