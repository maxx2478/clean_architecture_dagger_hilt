package com.manohar.movies_cleanarch.Data.repository.movie.datasource

import com.manohar.movies_cleanarch.Data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movie: List<Movie>)
    suspend fun clearAll()

}