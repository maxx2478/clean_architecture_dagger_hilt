package com.manohar.movies_cleanarch.Data.repository.artist.datasourceImpl

import com.manohar.movies_cleanarch.Data.model.artist.Artist
import com.manohar.movies_cleanarch.Data.repository.artist.datasource.ArtistCacheDataSource
import com.manohar.movies_cleanarch.Data.repository.artist.datasource.ArtistLocalDataSource
import com.manohar.movies_cleanarch.Data.repository.artist.datasource.ArtistRemoteDataSource
import com.manohar.movies_cleanarch.Domain.repositories.ArtistRepository
import java.lang.Exception

class ArtistRepoositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromAPI()
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getDataFromAPI()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {

        }
        return artistList
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newartistList = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveToLocalDB(newartistList)
        artistCacheDataSource.saveToCache(newartistList)
        return newartistList
    }


    suspend fun getArtistFromLocalDB(): List<Artist> {
        lateinit var artistlist: List<Artist>

        try {
            artistlist = artistLocalDataSource.getFromLocalDB()

        } catch (exception: Exception) {

        }
        if (artistlist.size > 0) {
            return artistlist
        } else {
            artistlist = getArtistFromAPI()
            artistLocalDataSource.saveToLocalDB(artistlist)
        }

        return artistlist
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistlist: List<Artist>

        try {
            artistlist = artistCacheDataSource.getFromCache()

        } catch (exception: Exception) {

        }
        if (artistlist.size > 0) {
            return artistlist
        } else {
            artistlist = getArtistFromLocalDB()
            artistCacheDataSource.saveToCache(artistlist)
        }

        return artistlist
    }


}