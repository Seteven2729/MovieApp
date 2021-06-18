package com.dicoding.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(var name: String,var description: String,var photo: Int,var favorite: Boolean):Parcelable
