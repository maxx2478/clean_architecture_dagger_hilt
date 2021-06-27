package com.manohar.movies_cleanarch.Data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manohar.movies_cleanarch.Data.model.artist.Artist
import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow


@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    //abstract fun tvDao(): TvShowDao
    //abstract fun artistDao(): ArtistDao


}