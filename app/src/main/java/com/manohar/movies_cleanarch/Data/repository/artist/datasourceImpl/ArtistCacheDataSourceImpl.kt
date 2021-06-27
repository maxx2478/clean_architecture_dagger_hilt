package com.manohar.movies_cleanarch.Data.repository.artist.datasourceImpl

import com.manohar.movies_cleanarch.Data.model.artist.Artist
import com.manohar.movies_cleanarch.Data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistlist = ArrayList<Artist>()

    override suspend fun saveToCache(list: List<Artist>) {
        artistlist = ArrayList(list)
    }

    override suspend fun getFromCache(): List<Artist> {
        return artistlist
    }

}