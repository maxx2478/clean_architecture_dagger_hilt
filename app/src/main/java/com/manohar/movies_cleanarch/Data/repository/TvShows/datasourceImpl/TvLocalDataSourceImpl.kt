package com.manohar.movies_cleanarch.Data.repository.TvShows.datasourceImpl

import com.manohar.movies_cleanarch.Data.db.TvShowDao
import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow
import com.manohar.movies_cleanarch.Data.repository.TvShows.datasource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowsLocalDataSource {
    override suspend fun savetoLocalDB(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvshow(tvshows)
        }
    }

    override suspend fun getFromLocalDB(): List<TvShow> {
        return tvShowDao.getAllTvshow()
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deteleAllTvshow()
        }
    }
}