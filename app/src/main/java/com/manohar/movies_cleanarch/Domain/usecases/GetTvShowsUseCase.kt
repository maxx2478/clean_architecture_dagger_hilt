package com.manohar.movies_cleanarch.Domain.usecases

import com.manohar.movies_cleanarch.Data.model.tvshoow.TvShow
import com.manohar.movies_cleanarch.Domain.repositories.TvShowsRepository

class GetTvShowsUseCase constructor(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvShows()

}
