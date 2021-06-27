package com.manohar.movies_cleanarch.Domain.usecases

import com.manohar.movies_cleanarch.Data.model.artist.Artist
import com.manohar.movies_cleanarch.Domain.repositories.ArtistRepository

class GetArtistsUseCase constructor(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? =  artistRepository.getArtists()

}