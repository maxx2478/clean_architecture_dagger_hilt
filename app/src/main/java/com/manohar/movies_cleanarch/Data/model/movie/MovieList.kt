package com.manohar.movies_cleanarch.Data.model.movie

data class MovieList(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int

    )