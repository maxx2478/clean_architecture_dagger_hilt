package com.manohar.movies_cleanarch.Data.repository.artist.datasourceImpl

import com.manohar.movies_cleanarch.Data.db.ArtistDao
import com.manohar.movies_cleanarch.Data.model.artist.Artist
import com.manohar.movies_cleanarch.Data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun saveToLocalDB(list: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(list)
        }
    }

    override suspend fun getFromLocalDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deteleAllArtist()
        }
    }
}