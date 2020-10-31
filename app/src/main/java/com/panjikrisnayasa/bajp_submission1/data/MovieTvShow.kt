package com.panjikrisnayasa.bajp_submission1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieTvShow(
    var id: String,
    var poster: String,
    var title: String,
    var userScore: String,
    var genre: String,
    var duration: String,
    var language: String,
    var year: String,
    var overview: String
) : Parcelable