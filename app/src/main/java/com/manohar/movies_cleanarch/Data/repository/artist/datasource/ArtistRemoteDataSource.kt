package com.manohar.movies_cleanarch.Data.repository.artist.datasource

import com.manohar.movies_cleanarch.Data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getDataFromAPI():Response<ArtistList>

}