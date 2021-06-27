package com.manohar.movies_cleanarch.Domain.repositories

import com.manohar.movies_cleanarch.Data.model.artist.Artist
import com.manohar.movies_cleanarch.Data.model.movie.Movie

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists():List<Artist>?

}