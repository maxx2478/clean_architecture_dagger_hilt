package com.manohar.movies_cleanarch.Presentation.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.liveData
import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Domain.usecases.GetMoviesUseCase
import com.manohar.movies_cleanarch.Domain.usecases.UpdateMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel
@Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
) : ViewModel() {

    fun getMovies() = liveData {
            val response = getMoviesUseCase.execute()
            emit(response)
            if (response!=null)
            Log.i("sizex", response.size.toString())
            else
                Log.i("sizex", "null")
    }.asFlow()

    fun updateMovies() = liveData {
        val response = updateMoviesUseCase.execute()
        emit(response)
    }

}