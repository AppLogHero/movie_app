package com.example.applog.movielist.Activitys

import android.media.Image
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.applog.movielist.Adapter.NewMovieAdapter
import com.example.applog.movielist.Adapter.RecommendedMovieAdapter
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val moviesRecommended: ArrayList<String> = ArrayList()
    val newMovies: ArrayList<String> = ArrayList()
    val moviePhotos: ArrayList<Image> = ArrayList()

    private lateinit var recommendedMovieRecyclerView: RecyclerView
    private lateinit var recommendedMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recommendedMovieViewManager: RecyclerView.LayoutManager

    private lateinit var newMovieRecyclerView: RecyclerView
    private lateinit var newMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var newMovieViewManager: RecyclerView.LayoutManager

    private lateinit var atTheMomentImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        setSupportActionBar(toolbar)

        addMovieRecommended()
        addNewMovie()

        recommendedMovieViewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recommendedMovieViewAdapter = RecommendedMovieAdapter(moviesRecommended)

        recommendedMovieRecyclerView = findViewById<RecyclerView>(R.id.recommended_movie_rc).apply {

            layoutManager = recommendedMovieViewManager
            adapter = recommendedMovieViewAdapter

        }

        newMovieViewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        newMovieViewAdapter = NewMovieAdapter(newMovies)

        newMovieRecyclerView = findViewById<RecyclerView>(R.id.new_movie_rc).apply {

            layoutManager = newMovieViewManager
            adapter = newMovieViewAdapter

        }

        atTheMomentImageView = findViewById<ImageView>(R.id.imageViewAtThMoment)
        Glide.with(this)
            .load("https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg")
            .into(atTheMomentImageView)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_action -> {

            }
            R.id.nav_adventure -> {

            }
            R.id.nav_romance -> {

            }
            R.id.nav_horror -> {

            }
            R.id.nav_SF -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun addMovieRecommended() {

        moviesRecommended.add("Movie Title yeah")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")
        moviesRecommended.add("Movie Title")

    }

    fun addNewMovie() {

        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")
        newMovies.add("Movie Title")

    }
}
