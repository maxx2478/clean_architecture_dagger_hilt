package com.manohar.movies_cleanarch.Presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manohar.movies_cleanarch.Domain.usecases.GetMoviesUseCase
import com.manohar.movies_cleanarch.Domain.usecases.UpdateMoviesUseCase
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
                as T
    }
}