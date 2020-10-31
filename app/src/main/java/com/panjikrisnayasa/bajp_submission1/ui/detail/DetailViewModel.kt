package com.panjikrisnayasa.bajp_submission1.ui.detail

import androidx.lifecycle.ViewModel
import com.panjikrisnayasa.bajp_submission1.data.MovieTvShow
import com.panjikrisnayasa.bajp_submission1.utils.DataDummy

class DetailViewModel : ViewModel() {

    fun getDetail(id: String): MovieTvShow {
        lateinit var movieTvShow: MovieTvShow

        val movies = DataDummy.generateDummyMovies()
        for (movie in movies) {
            if (id == movie.id) {
                movieTvShow = movie
                return movieTvShow
            }
        }

        val tvShows = DataDummy.generateDummyTvShows()
        for (tvShow in tvShows) {
            if (id == tvShow.id) {
                movieTvShow = tvShow
                return movieTvShow
            }
        }
        return movieTvShow
    }
}