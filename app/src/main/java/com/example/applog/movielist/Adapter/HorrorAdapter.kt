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
import kotlinx.android.synthetic.main.horror_movie_list_item.view.*

class HorrorAdapter(private val myDataset: ArrayList<Movie>) :
    RecyclerView.Adapter<HorrorAdapter.HorrorMovieViewHolder>() {

    class HorrorMovieViewHolder(val view: View, context: Context) : RecyclerView.ViewHolder(view) {

        val imageView = view.horror_movie_imageview

        val title = view.title_tv_horror
        val runtime = view.time_tv_horror
        val year = view.year_tv_horror
        val rate = view.rate_tv_horror

        val theSuperContext = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorrorMovieViewHolder {

        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.horror_movie_list_item, parent, false)

        return HorrorMovieViewHolder(cellForRow, parent.context)
    }

    override fun onBindViewHolder(holder: HorrorMovieViewHolder, position: Int) {

        holder.title.text = myDataset[position].title
        holder.runtime.text = myDataset[position].runtime
        holder.year.text = myDataset[position].year
        holder.rate.text = "8.5/10"

        Glide.with(holder.theSuperContext)
            .load(myDataset[position].poster)
            .into(holder.imageView)
    }

    override fun getItemCount() = myDataset.size
}