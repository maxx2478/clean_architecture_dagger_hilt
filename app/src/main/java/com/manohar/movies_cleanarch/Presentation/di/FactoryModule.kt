package com.manohar.movies_cleanarch.Presentation.di

import android.app.Application
import com.manohar.movies_cleanarch.Domain.repositories.MovieRepository
import com.manohar.movies_cleanarch.Presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun providesMovieViewModelFactory(
        movieRepository: MovieRepository,
        useCaseModule: UseCaseModule
    ): MovieViewModelFactory
    {
        return MovieViewModelFactory(useCaseModule.provideGetMovieUseCase(movieRepository),
        useCaseModule.provideUpdateMovieUseCase(movieRepository))
    }

}