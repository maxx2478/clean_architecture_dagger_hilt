package com.manohar.movies_cleanarch.Data.api

import com.manohar.movies_cleanarch.Data.model.artist.ArtistList
import com.manohar.movies_cleanarch.Data.model.movie.MovieList
import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TMDPService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apikey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apikey: String): Response<ArtistList>


}