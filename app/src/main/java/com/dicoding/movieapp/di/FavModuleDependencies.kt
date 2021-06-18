package com.dicoding.movieapp.di

import com.dicoding.movieapp.core.domain.usecase.MovieUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent



@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FavModuleDependencies {
    fun mUseCase(): MovieUseCase
}