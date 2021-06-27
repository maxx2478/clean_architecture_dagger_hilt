package com.manohar.movies_cleanarch.Data.repository.TvShows.datasourceImpl

import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow
import com.manohar.movies_cleanarch.Data.repository.TvShows.datasource.TvShowsCacheDataSource
import com.manohar.movies_cleanarch.Data.repository.TvShows.datasource.TvShowsLocalDataSource
import com.manohar.movies_cleanarch.Data.repository.TvShows.datasource.TvShowsRemoteDataSource
import com.manohar.movies_cleanarch.Domain.repositories.TvShowsRepository
import java.lang.Exception

class TvShowsRepositoryImpl(
    private val tvShowsCacheDataSource: TvShowsCacheDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource

) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvshowsFromApi()
    }

    override suspend fun updateTvShow(): List<TvShow> {
        //fetch fresh list, clear saved list and save newly fresh list.
        val tvsjpwslist = getTvshowsFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.savetoLocalDB(tvsjpwslist)
        tvShowsCacheDataSource.savetoCache(tvsjpwslist)
        return tvsjpwslist

    }

    suspend fun getTvshowsFromApi(): List<TvShow> {
        lateinit var tvshowslist: List<TvShow>

        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvshowslist = body.tvShows
            }
        } catch (e: Exception) {

        }

        return tvshowslist

    }

    suspend fun getTvshowsFromLocalDB(): List<TvShow> {
        lateinit var tvshowslist: List<TvShow>

        try {
            tvshowslist = tvShowsLocalDataSource.getFromLocalDB()

        } catch (e: Exception) {

        }

        if (tvshowslist.size > 0) {
            return tvshowslist
        } else {
            tvshowslist = getTvshowsFromApi()
            tvShowsLocalDataSource.savetoLocalDB(tvshowslist)
        }

        return tvshowslist

    }

    suspend fun getTvShowsfromCache(): List<TvShow> {
        lateinit var tvshowslist: List<TvShow>

        try {
            tvshowslist = tvShowsCacheDataSource.getFromCache()

        } catch (exception: Exception) {

        }
        if (tvshowslist.size > 0) {
            return tvshowslist
        } else {
            tvshowslist = getTvshowsFromLocalDB()
            tvShowsCacheDataSource.savetoCache(tvshowslist)
        }

        return tvshowslist
    }


}