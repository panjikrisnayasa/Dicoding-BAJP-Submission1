package com.panjikrisnayasa.bajp_submission1.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panjikrisnayasa.bajp_submission1.R
import com.panjikrisnayasa.bajp_submission1.data.MovieTvShow
import com.panjikrisnayasa.bajp_submission1.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_movies_tv_shows.view.*

class MoviesTvShowsAdapter : RecyclerView.Adapter<MoviesTvShowsAdapter.MoviesTvShowsViewHolder>() {

    private var mListMoviesTvShows = ArrayList<MovieTvShow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesTvShowsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movies_tv_shows, parent, false)
        return MoviesTvShowsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesTvShowsViewHolder, position: Int) {
        val movieTvShow = mListMoviesTvShows[position]
        holder.bind(movieTvShow)
    }

    override fun getItemCount(): Int = mListMoviesTvShows.size

    fun setMoviesTvShows(moviesTvShows: List<MovieTvShow>?) {
        if (moviesTvShows == null) return
        mListMoviesTvShows.clear()
        mListMoviesTvShows.addAll(moviesTvShows)
    }

    inner class MoviesTvShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieTvShow: MovieTvShow) {
            with(itemView) {
                text_item_movies_tv_shows_title.text = movieTvShow.title

                val rating = movieTvShow.userScore.toFloat() / 20
                rating_item_movies_tv_shows.rating = rating
                text_item_movies_tv_shows_rating.text = rating.toString()

                text_item_movies_tv_shows_genre.text = movieTvShow.genre
                text_item_movies_tv_shows_duration.text = movieTvShow.duration
                text_item_movies_tv_shows_year.text = movieTvShow.year

                image_item_movies_tv_shows_poster.clipToOutline = true
                val drawableResourceId =
                    resources.getIdentifier(movieTvShow.poster, "drawable", context.packageName)
                Glide.with(this).load(drawableResourceId).into(image_item_movies_tv_shows_poster)

                setOnClickListener {
                    val intentDetail = Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_ID, movieTvShow.id)
                    }
                    context.startActivity(intentDetail)
                }
            }
        }
    }
}