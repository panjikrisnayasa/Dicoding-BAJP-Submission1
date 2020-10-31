package com.panjikrisnayasa.bajp_submission1.ui.detail

import com.panjikrisnayasa.bajp_submission1.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var mViewModel: DetailViewModel
    private val mMovie = DataDummy.generateDummyMovies()[0]
    private val mTvShow = DataDummy.generateDummyTvShows()[0]

    @Before
    fun setUp() {
        mViewModel = DetailViewModel()
    }

    @Test
    fun getDetailMovie() {
        val movie = mViewModel.getDetail(mMovie.id)
        assertNotNull(movie)
        assertEquals(mMovie.id, movie.id)
        assertEquals(mMovie.poster, movie.poster)
        assertEquals(mMovie.title, movie.title)
        assertEquals(mMovie.genre, movie.genre)
        assertEquals(mMovie.duration, movie.duration)
        assertEquals(mMovie.language, movie.language)
        assertEquals(mMovie.overview, movie.overview)
        assertEquals(mMovie.userScore, movie.userScore)
        assertEquals(mMovie.year, movie.year)
    }

    @Test
    fun getDetailTvShow() {
        val tvShow = mViewModel.getDetail(mTvShow.id)
        assertNotNull(tvShow)
        assertEquals(mTvShow.id, tvShow.id)
        assertEquals(mTvShow.poster, tvShow.poster)
        assertEquals(mTvShow.title, tvShow.title)
        assertEquals(mTvShow.genre, tvShow.genre)
        assertEquals(mTvShow.duration, tvShow.duration)
        assertEquals(mTvShow.language, tvShow.language)
        assertEquals(mTvShow.overview, tvShow.overview)
        assertEquals(mTvShow.userScore, tvShow.userScore)
        assertEquals(mTvShow.year, tvShow.year)
    }
}