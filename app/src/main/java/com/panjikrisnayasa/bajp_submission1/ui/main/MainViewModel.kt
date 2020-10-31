package com.panjikrisnayasa.bajp_submission1.ui.main

import androidx.lifecycle.ViewModel
import com.panjikrisnayasa.bajp_submission1.data.MovieTvShow
import com.panjikrisnayasa.bajp_submission1.utils.DataDummy

class MainViewModel : ViewModel() {

    fun getMovies(): List<MovieTvShow> = DataDummy.generateDummyMovies()

    fun getTvShows(): List<MovieTvShow> = DataDummy.generateDummyTvShows()
}