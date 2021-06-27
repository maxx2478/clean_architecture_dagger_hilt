package com.manohar.movies_cleanarch.Presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.manohar.movies_cleanarch.Data.db.MovieDao
import com.manohar.movies_cleanarch.Data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule{

    @Provides
    @Singleton
    fun providesMovieDatabase(application: Application): TMDBDatabase
    {
        return Room.databaseBuilder(application.baseContext, TMDBDatabase::class.java, "tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao
    {
        return tmdbDatabase.movieDao()
    }


}