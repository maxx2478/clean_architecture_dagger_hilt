package com.manohar.movies_cleanarch.Data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)