package com.dicoding.movieapp.core.domain.usecase


import com.dicoding.movieapp.core.domain.model.Movie
import com.dicoding.movieapp.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase  {
    override fun getAllMovie(): Flow<com.dicoding.movieapp.core.data.Resource<List<Movie>>> = movieRepository.getAllMovie()
    override fun getFavoriteMovie(): Flow<List<Movie>> = movieRepository.getFavoriteMovie()
    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieRepository.setFavoriteMovie(movie,state)
}