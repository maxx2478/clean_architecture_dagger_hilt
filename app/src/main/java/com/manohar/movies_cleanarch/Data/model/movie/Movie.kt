package com.manohar.movies_cleanarch.Data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    val id: Int,
    val overview: String,
    val poster_path: String,
    val title: String,
)