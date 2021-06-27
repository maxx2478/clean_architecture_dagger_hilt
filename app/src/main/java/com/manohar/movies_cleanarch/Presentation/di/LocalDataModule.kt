package com.manohar.movies_cleanarch.Presentation.di

import com.manohar.movies_cleanarch.Data.db.MovieDao
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieLocalDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class LocalDataModule {

    @Provides
    @Singleton
    fun provideMovieLocalDataSourcec(movieDao: MovieDao):MovieLocalDataSource
    {
       return  MovieLocalDataSourceImpl(movieDao)
    }

}