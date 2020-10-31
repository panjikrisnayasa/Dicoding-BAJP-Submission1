package com.panjikrisnayasa.bajp_submission1.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.panjikrisnayasa.bajp_submission1.R

class MainViewPagerAdapter(fragmentManager: FragmentManager, context: Context) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mContext = context

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return MoviesFragment()
            1 -> return TvShowsFragment()
        }
        return MoviesFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return mContext.getString(R.string.title_movies)
            1 -> return mContext.getString(R.string.title_tv_shows)
        }
        return super.getPageTitle(position)
    }
}