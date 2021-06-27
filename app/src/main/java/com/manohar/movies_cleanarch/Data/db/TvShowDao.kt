package com.manohar.movies_cleanarch.Data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvshow(movies: List<TvShow>)

    @Query("Delete from popular_tvshows")
    suspend fun deteleAllTvshow()

    @Query("Select * from popular_tvshows")
    suspend fun getAllTvshow():List<TvShow>

}