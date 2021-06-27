package com.manohar.movies_cleanarch.Data.repository.movie.datasource

import com.manohar.movies_cleanarch.Data.model.movie.Movie

interface MoviesCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movie: List<Movie>)

}