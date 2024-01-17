package com.example.heroesday1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val superpower: String,
    val ranking: Int,
    val image: String
): Parcelable, Comparable<Hero> {
    override fun compareTo(other: Hero): Int {
        // ranking will be the natural order
        // if the current her is rank 1
        // the other hero is rank 3
        // the result should be -2
        return this.ranking - other.ranking
    }
}