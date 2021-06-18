package com.dicoding.movieapp.fav

import android.content.Context
import com.dicoding.movieapp.di.FavModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavModuleDependencies::class])
interface FavsComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: FavModuleDependencies): Builder
        fun build(): FavsComponent
    }

}