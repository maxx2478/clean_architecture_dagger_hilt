package com.manohar.movies_cleanarch.Presentation.di

import android.content.Context
import androidx.room.Room
import com.manohar.movies_cleanarch.Data.api.TMDPService
import com.manohar.movies_cleanarch.Data.db.MovieDao
import com.manohar.movies_cleanarch.Data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl():String = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun providesRetrofit(baseurl:String) : Retrofit =
        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideApiInterface(retrofit: Retrofit) : TMDPService =
        retrofit.create(TMDPService::class.java)



}

