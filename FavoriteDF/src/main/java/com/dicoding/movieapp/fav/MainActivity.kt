package com.dicoding.movieapp.fav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieapp.core.data.Resource
import com.dicoding.movieapp.core.ui.MovieAdapter
import com.dicoding.movieapp.detail.DetailMovieActivity
import com.dicoding.movieapp.di.FavModuleDependencies
import com.dicoding.movieapp.fav.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val favViewModel: FavsViewModel by viewModels {
        factory
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavsComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Dynamic Feature"
        val movieAdapter =MovieAdapter()
        favViewModel.movie.observe(this, { dataMovie ->
            movieAdapter.setData(dataMovie)
        })

        with(binding.rvTourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

    }


}