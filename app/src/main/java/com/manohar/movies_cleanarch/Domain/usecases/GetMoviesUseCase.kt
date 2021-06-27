package com.manohar.movies_cleanarch.Domain.usecases

import com.manohar.movies_cleanarch.Data.model.movie.Movie
import com.manohar.movies_cleanarch.Domain.repositories.MovieRepository

class GetMoviesUseCase constructor(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()

}