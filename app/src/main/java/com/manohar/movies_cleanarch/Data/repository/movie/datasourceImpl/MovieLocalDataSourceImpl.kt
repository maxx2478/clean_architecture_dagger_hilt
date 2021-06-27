package com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl

import com.manohar.movies_cleanarch.Data.db.MovieDao
import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getAllMovies()
    }

    override suspend fun saveMoviesToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movie)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deteleAllMovies()
        }

    }
}