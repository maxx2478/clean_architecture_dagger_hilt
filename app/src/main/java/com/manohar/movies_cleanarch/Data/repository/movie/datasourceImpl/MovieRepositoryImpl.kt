package com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl

import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieLocalDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieRemoteDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MoviesCacheDataSource
import com.manohar.movies_cleanarch.Domain.repositories.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val moviesCacheDataSource: MoviesCacheDataSource
) : MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
       return getMoviesFromApi()
    }

    override suspend fun updateMovies(): List<Movie>? {
       val newListofMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListofMovies)
        moviesCacheDataSource.saveMoviesToCache(newListofMovies)
        return newListofMovies
    }

    suspend fun getMoviesFromApi():List<Movie>{
        var movielist:List<Movie> = listOf()

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!=null)
            {
                movielist = body.results
            }
        }
        catch (exception: Exception)
        {

        }
        return movielist

    }

    suspend fun getMoviesFromDB():List<Movie>
    {
         var movielist:List<Movie> = listOf()

        try {
            movielist = movieLocalDataSource.getMoviesFromDB()

        }
        catch (exception: Exception)
        {

        }
        if (movielist.size>0)
        {
            return movielist
        }
        else
        {
            movielist = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movielist)
        }

        return movielist
    }

    suspend fun getMoviesfromCache():List<Movie>
    {
         var movielist:List<Movie> = listOf()

        try {
            movielist = moviesCacheDataSource.getMoviesFromCache()

        }
        catch (exception: Exception)
        {

        }
        if (movielist.size>0)
        {
            return movielist
        }
        else
        {
            movielist = getMoviesFromDB()
            moviesCacheDataSource.saveMoviesToCache(movielist)
        }

        return movielist
    }



}