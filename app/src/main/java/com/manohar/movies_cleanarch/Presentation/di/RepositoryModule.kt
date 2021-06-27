package com.manohar.movies_cleanarch.Presentation.di

import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieLocalDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieRemoteDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MoviesCacheDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl.MovieRepositoryImpl
import com.manohar.movies_cleanarch.Domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class RepositoryModule {


    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        moviesCacheDataSource: MoviesCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ) : MovieRepository
    {
        return MovieRepositoryImpl(movieRemoteDataSource,
            movieLocalDataSource,
            moviesCacheDataSource)
    }

}