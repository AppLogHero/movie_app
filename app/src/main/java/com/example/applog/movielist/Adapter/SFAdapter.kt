package com.example.applog.movielist.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.applog.movielist.Models.Movie
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.action_movie_list_item.view.*
import kotlinx.android.synthetic.main.sf_movie_list_item.view.*

class SFAdapter(private val myDataset: ArrayList<Movie>) :
    RecyclerView.Adapter<SFAdapter.SFMovieViewHolder>() {

    class SFMovieViewHolder(val view: View, context: Context) : RecyclerView.ViewHolder(view) {

        val imageView = view.sf_movie_imageview

        val title = view.title_tv_sf
        val runtime = view.time_tv_sf
        val year = view.year_tv_sf
        val rate = view.rate_tv_sf

        val theSuperContext = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SFMovieViewHolder {

        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.sf_movie_list_item, parent, false)

        return SFMovieViewHolder(cellForRow, parent.context)
    }

    override fun onBindViewHolder(holder: SFMovieViewHolder, position: Int) {

        holder.title.text = myDataset[position].title
        holder.runtime.text = myDataset[position].runtime
        holder.year.text = myDataset[position].year
        holder.rate.text = "8.5/10"

        Glide.with(holder.theSuperContext)
            .load("https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg")
            .into(holder.imageView)
    }

    override fun getItemCount() = myDataset.size
}