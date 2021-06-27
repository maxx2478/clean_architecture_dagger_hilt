package com.manohar.movies_cleanarch.Presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.manohar.movies_cleanarch.R
import com.manohar.movies_cleanarch.databinding.ActivityMovieShowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieShowBinding
    private var mainViewModel:MovieViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_show)
        binding = ActivityMovieShowBinding.inflate(layoutInflater)
        val viewInflater = binding.root
        setContentView(viewInflater)

        mainViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        mainViewModel!!.getMovies()


    }
}