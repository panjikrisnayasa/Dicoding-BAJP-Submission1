package com.panjikrisnayasa.bajp_submission1.ui.main

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var mViewModel: MainViewModel

    @Before
    fun setUp() {
        mViewModel = MainViewModel()
    }

    @Test
    fun getMovies() {
        val movies = mViewModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun getTvShows() {
        val tvShows = mViewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }
}