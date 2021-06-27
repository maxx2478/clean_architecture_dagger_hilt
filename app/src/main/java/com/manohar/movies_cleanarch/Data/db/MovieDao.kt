package com.manohar.movies_cleanarch.Data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manohar.movies_cleanarch.Data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("Delete from popular_movies")
    suspend fun deteleAllMovies()

    @Query("Select * from popular_movies")
    suspend fun getAllMovies():List<Movie>

}