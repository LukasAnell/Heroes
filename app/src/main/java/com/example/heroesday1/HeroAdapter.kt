package com.example.heroesday1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(private var heroList: List<Hero>): RecyclerView.Adapter<HeroAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val descriptionTextView: TextView
        val rankingTextView: TextView
        val layout: ConstraintLayout

        init {
            nameTextView = view.findViewById(R.id.textView_heroItem_name)
            descriptionTextView = view.findViewById(R.id.textView_heroItem_description)
            rankingTextView = view.findViewById(R.id.textView_heroItem_ranking)
            layout = view.findViewById(R.id.layout_itemHero)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_hero, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val context = viewHolder.layout.context
        val hero = heroList[position]
        viewHolder.nameTextView.text = hero.name
        viewHolder.descriptionTextView.text = hero.description
        viewHolder.rankingTextView.text = hero.ranking.toString()

        viewHolder.layout.setOnClickListener {
            // Toast.makeText(context, hero.name, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, HeroesDetailActivity::class.java)

            intent.putExtra("name", hero.name)
            intent.putExtra("description", hero.description)
            intent.putExtra("ranking", hero.ranking.toString())
            intent.putExtra("superpower", hero.superpower)
            intent.putExtra("image", hero.image)

            context.startActivity(intent)
        }
    }

    override fun getItemCount() = heroList.size
}