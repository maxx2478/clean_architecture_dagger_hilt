package com.manohar.movies_cleanarch.Data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manohar.movies_cleanarch.Data.model.artist.Artist


@Dao
interface ArtistDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(movies: List<Artist>)

    @Query("Delete from popular_artists")
    suspend fun deteleAllArtist()

    @Query("Select * from popular_artists")
    suspend fun getAllArtists():List<Artist>

}