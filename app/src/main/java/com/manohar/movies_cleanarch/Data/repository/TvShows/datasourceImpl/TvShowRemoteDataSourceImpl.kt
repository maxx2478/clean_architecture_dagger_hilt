package com.manohar.movies_cleanarch.Data.repository.TvShows.datasourceImpl

import com.manohar.movies_cleanarch.Data.api.TMDPService
import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShowList
import com.manohar.movies_cleanarch.Data.repository.TvShows.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdpService: TMDPService,
    private val apikey: String
) : TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdpService.getPopularTvShows(apikey)
    }
}