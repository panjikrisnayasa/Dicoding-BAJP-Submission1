package com.panjikrisnayasa.bajp_submission1.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.panjikrisnayasa.bajp_submission1.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        image_detail_poster.clipToOutline = true

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_ID)
        if (id != null) {
            val detailMovieTvShow = viewModel.getDetail(id)
            supportActionBar?.title = detailMovieTvShow.title
            text_detail_title.text = detailMovieTvShow.title

            val rating = detailMovieTvShow.userScore.toFloat() / 20
            rating_detail.rating = rating
            text_detail_rating.text = rating.toString()

            text_detail_genre.text = detailMovieTvShow.genre
            text_detail_duration.text = detailMovieTvShow.duration
            text_detail_year.text = detailMovieTvShow.year
            text_detail_language.text = detailMovieTvShow.language
            text_detail_overview.text = detailMovieTvShow.overview

            image_detail_poster.clipToOutline = true
            val drawableResourceId =
                resources.getIdentifier(detailMovieTvShow.poster, "drawable", packageName)
            Glide.with(this).load(drawableResourceId).into(image_detail_poster)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}