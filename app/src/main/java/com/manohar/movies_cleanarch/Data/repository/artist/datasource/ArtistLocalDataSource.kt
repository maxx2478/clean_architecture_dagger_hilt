package com.manohar.movies_cleanarch.Data.repository.artist.datasource

import com.manohar.movies_cleanarch.Data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun saveToLocalDB(list:List<Artist>)
    suspend fun getFromLocalDB():List<Artist>
    suspend fun clearAll()

}