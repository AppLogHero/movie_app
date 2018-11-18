package com.example.applog.movielist.Activitys.RecyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.applog.movielist.R

class MovieListActivity : AppCompatActivity() {

    val movies: ArrayList<String> = ArrayList()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rv_movie_list)

        addMovieForTestingRv()

        viewManager = LinearLayoutManager(this)
        viewAdapter = MovieAdapter(movies)

        recyclerView = findViewById<RecyclerView>(R.id.rv_movie_list).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
    }

    fun addMovieForTestingRv() {

        movies.add("Movie Title yeah")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")
        movies.add("Movie Title")

    }

}
