package com.manohar.movies_cleanarch.Presentation.di

import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MoviesCacheDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MoviesCacheDataSource
    {
        return MovieCacheDataSourceImpl()
    }

}