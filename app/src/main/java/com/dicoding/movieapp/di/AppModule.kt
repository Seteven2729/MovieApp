package com.dicoding.movieapp.di

import com.dicoding.movieapp.core.domain.usecase.MovieInteractor
import com.dicoding.movieapp.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds

    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

}