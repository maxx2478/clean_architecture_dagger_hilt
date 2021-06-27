package com.manohar.movies_cleanarch.Presentation.di

import androidx.viewbinding.BuildConfig
import com.manohar.movies_cleanarch.Data.api.TMDPService
import com.manohar.movies_cleanarch.Data.repository.movie.datasource.MovieRemoteDataSource
import com.manohar.movies_cleanarch.Data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
public class RemoteDataModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(tmdpService: TMDPService):MovieRemoteDataSource
    {
        return MovieRemoteDataSourceImpl(
            tmdpService, com.manohar.movies_cleanarch.BuildConfig.API_KEY
        )

    }


}
