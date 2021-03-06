package com.dicoding.movieapp.core.data.source.local.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.movieapp.core.data.source.local.entity.MovieEntity

@Database(entities = [com.dicoding.movieapp.core.data.source.local.entity.MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): com.dicoding.movieapp.core.data.source.local.room.MovieDAO

}