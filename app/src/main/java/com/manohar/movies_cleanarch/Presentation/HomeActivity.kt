package com.manohar.movies_cleanarch.Presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.manohar.movies_cleanarch.Presentation.movie.MovieShowActivity
import com.manohar.movies_cleanarch.R
import com.manohar.movies_cleanarch.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.moviesApi.setOnClickListener {
          startActivity(Intent(this@HomeActivity, MovieShowActivity::class.java))
        }




    }
}