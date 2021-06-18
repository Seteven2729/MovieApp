package com.dicoding.movieapp.favorite




import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.movieapp.core.domain.usecase.MovieUseCase



class FavoriteViewModel @ViewModelInject constructor(movieUseCase: MovieUseCase) : ViewModel() {

    val favoriteMovie =  movieUseCase.getFavoriteMovie().asLiveData()


}

