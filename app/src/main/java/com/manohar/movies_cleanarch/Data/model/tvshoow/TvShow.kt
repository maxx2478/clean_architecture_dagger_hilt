package com.manohar.movies_cleanarch.Data.model.tvshoow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_tvshows")
data class TvShow(

    @PrimaryKey
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,

)