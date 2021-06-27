package com.manohar.movies_cleanarch.Domain.repositories

import com.manohar.movies_cleanarch.Data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies():List<Movie>?


}