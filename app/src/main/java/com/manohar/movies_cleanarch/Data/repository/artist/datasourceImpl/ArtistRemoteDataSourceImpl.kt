package com.manohar.movies_cleanarch.Data.repository.artist.datasourceImpl

import com.manohar.movies_cleanarch.Data.api.TMDPService
import com.manohar.movies_cleanarch.Data.model.artist.ArtistList
import com.manohar.movies_cleanarch.Data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdpService: TMDPService,
    private val apikey: String
) : ArtistRemoteDataSource {
    override suspend fun getDataFromAPI(): Response<ArtistList> {
        return tmdpService.getPopularArtists(apikey)
    }
}