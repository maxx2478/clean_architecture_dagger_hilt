package com.manohar.movies_cleanarch.Data.repository.TvShows.datasource

import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow

interface TvShowsLocalDataSource {

    suspend fun savetoLocalDB(tvshows: List<TvShow>)
    suspend fun getFromLocalDB(): List<TvShow>
    suspend fun clearAll()

}