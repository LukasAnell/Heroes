package com.example.heroesday1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(private val heroList: List<Hero>): RecyclerView.Adapter<HeroAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val descriptionTextView: TextView
        val rankingTextView: TextView

        init {
            nameTextView = view.findViewById(R.id.textView_heroItem_name)
            descriptionTextView = view.findViewById(R.id.textView_heroItem_description)
            rankingTextView = view.findViewById(R.id.textView_heroItem_ranking)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_hero, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val hero = heroList[position]
        viewHolder.nameTextView.text = hero.name
        viewHolder.descriptionTextView.text = hero.description
        viewHolder.rankingTextView.text = hero.ranking.toString()
    }

    override fun getItemCount() = heroList.size
}