package com.dicoding.movieapp.core.di

import android.content.Context
import com.dicoding.movieapp.core.utils.JsonHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataSourceModule {
    @Singleton
    @Provides
    fun provideJsonHelper(@ApplicationContext context: Context): JsonHelper {
        return JsonHelper(context)
    }
}