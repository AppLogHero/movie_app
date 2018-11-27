package com.example.applog.movielist.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.applog.movielist.Models.Movie
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.movie_list_item.view.*

class RecommendedMovieAdapter(private val myDataset: ArrayList<Movie>) :
    RecyclerView.Adapter<RecommendedMovieAdapter.RecommendedViewHolder>() {

    class RecommendedViewHolder(val view: View, context: Context) : RecyclerView.ViewHolder(view) {

        val imageView = view.imageView

        val tvMovieTitle = view.tv_movie_title

        val theSuperContext = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {

        val textView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)

        return RecommendedViewHolder(
            textView,
            parent.context
        )
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.tvMovieTitle.text = myDataset[position].title

        Glide.with(holder.theSuperContext)
            .load(myDataset[position].poster)
            .into(holder.imageView)

    }

    override fun getItemCount() = myDataset.size
}