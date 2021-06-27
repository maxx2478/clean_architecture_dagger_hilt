package com.manohar.movies_cleanarch.Data.repository.TvShows.datasourceImpl

import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow
import com.manohar.movies_cleanarch.Data.repository.TvShows.datasource.TvShowsCacheDataSource

class TvCacheDataSourceImpl : TvShowsCacheDataSource {
    private var tvshowslist = ArrayList<TvShow>()
    override suspend fun savetoCache(tvshows: List<TvShow>) {
        tvshowslist.clear()
        tvshowslist = ArrayList(tvshows)
    }

    override suspend fun getFromCache(): List<TvShow> {
        return tvshowslist
    }
}