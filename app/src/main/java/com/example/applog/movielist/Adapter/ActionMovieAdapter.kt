package com.example.applog.movielist.Adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.applog.movielist.Models.Movie
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.action_movie_list_item.view.*
import kotlinx.android.synthetic.main.movie_list_item.view.*

class ActionMovieAdapter(private val myDataset: ArrayList<Movie>) :
    RecyclerView.Adapter<ActionMovieAdapter.ActionMovieViewHolder>() {

    class ActionMovieViewHolder(val view: View, context: Context) : RecyclerView.ViewHolder(view) {

        val imageView = view.action_movie_imageview

        val title = view.title_tv
        val runtime = view.time_tv
        val year = view.year_tv
        val rate = view.rate_tv

        val theSuperContext = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionMovieViewHolder {

        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.action_movie_list_item, parent, false)

        return ActionMovieViewHolder(cellForRow, parent.context)
    }

    override fun onBindViewHolder(holder: ActionMovieViewHolder, position: Int) {

        holder.title.text = myDataset[position].title
        holder.runtime.text = myDataset[position].runtime
        holder.year.text = myDataset[position].year
        holder.rate.text = "8.5/10"

        var uri = Uri.parse(myDataset[position].poster)

        Glide.with(holder.theSuperContext)
            .load(uri)
            .apply( RequestOptions().override(150, 200))
            .into(holder.imageView)
    }

    override fun getItemCount() = myDataset.size

}