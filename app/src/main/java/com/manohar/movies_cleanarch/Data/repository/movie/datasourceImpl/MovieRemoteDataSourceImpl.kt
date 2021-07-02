package com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl

import com.manohar.movies_cleanarch.BuildConfig
import com.manohar.movies_cleanarch.Data.api.TMDPService
import com.manohar.movies_cleanarch.Data.model.movie.MovieList
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdpService: TMDPService,
    private val apikey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
         tmdpService.getPopularMovies(BuildConfig.API_KEY)

}