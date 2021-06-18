package com.dicoding.movieapp.core.utils

import com.dicoding.movieapp.core.data.source.local.entity.MovieEntity
import com.dicoding.movieapp.core.data.source.remote.response.CinemaDataResponses
import com.dicoding.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<CinemaDataResponses>): List<com.dicoding.movieapp.core.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.dicoding.movieapp.core.data.source.local.entity.MovieEntity>()
        input.map {
            val movie = com.dicoding.movieapp.core.data.source.local.entity.MovieEntity(
                name = it.name,
                description = it.description,
                photo = it.photo,
                favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<com.dicoding.movieapp.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                name = it.name,
                description = it.description,
                photo = it.photo,
                favorite = it.favorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        com.dicoding.movieapp.core.data.source.local.entity.MovieEntity(
            name = input.name,
            description = input.description,
            photo = input.photo,
            favorite = input.favorite
        )

}