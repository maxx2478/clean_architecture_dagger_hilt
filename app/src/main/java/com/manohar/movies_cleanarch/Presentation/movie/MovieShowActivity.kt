package com.manohar.movies_cleanarch.Presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.manohar.movies_cleanarch.R
import com.manohar.movies_cleanarch.databinding.ActivityMovieShowBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MovieShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieShowBinding
   private val movieViewModel:MovieViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_show)
        binding = ActivityMovieShowBinding.inflate(layoutInflater)
        val viewInflater = binding.root
        setContentView(viewInflater)



    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenCreated {
            movieViewModel.getMovies().collect {

            }
        }

    }



}