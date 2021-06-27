package com.manohar.movies_cleanarch.Data.repository.TvShows.datasource

import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow

interface TvShowsCacheDataSource {

    suspend fun savetoCache(tvshows:List<TvShow>)
    suspend fun getFromCache():List<TvShow>

}