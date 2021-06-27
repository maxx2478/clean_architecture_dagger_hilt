package com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl

import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MoviesCacheDataSource

class MovieCacheDataSourceImpl: MoviesCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)

    }

}