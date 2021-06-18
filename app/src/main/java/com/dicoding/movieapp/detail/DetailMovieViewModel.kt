package com.dicoding.movieapp.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.dicoding.movieapp.core.domain.model.Movie
import com.dicoding.movieapp.core.domain.usecase.MovieUseCase


class DetailMovieViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) = movieUseCase.setFavoriteMovie(movie,newStatus)
}

