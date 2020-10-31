package com.panjikrisnayasa.bajp_submission1.ui.main

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.panjikrisnayasa.bajp_submission1.R
import com.panjikrisnayasa.bajp_submission1.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private val mMovies = DataDummy.generateDummyMovies()
    private val mTvShows = DataDummy.generateDummyTvShows()
    private val mIntent =
        Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)

    @get:Rule
    val mActivityRule = ActivityScenarioRule<MainActivity>(mIntent)

    @Test
    fun loadMovies() {
        onView(withId(R.id.recycler_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                mMovies.size - 1
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.recycler_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.text_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_detail_title)).check(matches(withText(mMovies[0].title)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.recycler_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                mTvShows.size - 1
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.recycler_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.text_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_detail_title)).check(matches(withText(mTvShows[0].title)))
    }
}