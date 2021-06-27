package com.manohar.movies_cleanarch.Data.repository.movie.datasource

import com.manohar.movies_cleanarch.Data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>



}