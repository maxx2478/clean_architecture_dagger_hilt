package com.manohar.movies_cleanarch.Data.repository.TvShows.datasource

import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {

    suspend fun getTvShows():Response<TvShowList>

}