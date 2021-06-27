package com.manohar.movies_cleanarch.Presentation.di

import com.manohar.movies_cleanarch.Domain.repositories.MovieRepository
import com.manohar.movies_cleanarch.Domain.usecases.GetMoviesUseCase
import com.manohar.movies_cleanarch.Domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieUseCase(movieRepository: MovieRepository):
            GetMoviesUseCase
    {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):
            UpdateMoviesUseCase
    {
        return UpdateMoviesUseCase(movieRepository)
    }



}