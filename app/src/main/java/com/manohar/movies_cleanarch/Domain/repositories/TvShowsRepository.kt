package com.manohar.movies_cleanarch.Domain.repositories

import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow

interface TvShowsRepository {

    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShow():List<TvShow>?

}