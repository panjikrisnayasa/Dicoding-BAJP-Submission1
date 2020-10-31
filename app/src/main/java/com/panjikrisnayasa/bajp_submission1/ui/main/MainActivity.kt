package com.panjikrisnayasa.bajp_submission1.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panjikrisnayasa.bajp_submission1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabLayout()
    }

    private fun setupTabLayout() {
        supportActionBar?.elevation = 0f
        pager_main.adapter = MainViewPagerAdapter(supportFragmentManager, applicationContext)
        tab_main.setupWithViewPager(pager_main)
    }
}