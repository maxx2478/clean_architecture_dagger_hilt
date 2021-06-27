package com.manohar.movies_cleanarch.Data.repository.artist.datasource

import com.manohar.movies_cleanarch.Data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun saveToCache(list:List<Artist>)
    suspend fun getFromCache():List<Artist>

}