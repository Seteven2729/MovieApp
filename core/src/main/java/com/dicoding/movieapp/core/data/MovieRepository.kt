package com.dicoding.movieapp.core.data

import com.dicoding.movieapp.core.data.source.remote.network.ApiResponse
import com.dicoding.movieapp.core.data.source.local.LocalDataSource
import com.dicoding.movieapp.core.data.source.remote.RemoteDataSource
import com.dicoding.movieapp.core.data.source.remote.response.CinemaDataResponses
import com.dicoding.movieapp.core.domain.model.Movie
import com.dicoding.movieapp.core.domain.repository.IMovieRepository
import com.dicoding.movieapp.core.utils.AppExecutors
import com.dicoding.movieapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
):IMovieRepository {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : com.dicoding.movieapp.core.data.NetworkBoundResource<List<Movie>, List<CinemaDataResponses>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<CinemaDataResponses>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<CinemaDataResponses>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
    }
}

