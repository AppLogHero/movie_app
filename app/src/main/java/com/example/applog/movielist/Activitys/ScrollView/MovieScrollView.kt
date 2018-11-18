package com.example.applog.movielist.Activitys.ScrollView

import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.applog.movielist.R

class MovieScrollView: AppCompatActivity() {

    val moviesRecommended: ArrayList<String> = ArrayList()
    val newMovies: ArrayList<String> = ArrayList()
    val moviePhotos: ArrayList<Image> = ArrayList()

    private lateinit var recommendedMovieRecyclerView: RecyclerView
    private lateinit var recommendedMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recommendedMovieViewManager: RecyclerView.LayoutManager

    private lateinit var newMovieRecyclerView: RecyclerView
    private lateinit var newMovieViewAdapter: RecyclerView.Adapter<*>
    private lateinit var newMovieViewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_scrollview)

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