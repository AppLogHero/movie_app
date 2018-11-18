package com.example.applog.movielist.Activitys.RecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieAdapter(private val myDataset: ArrayList<String>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvMovieTitle = view.tv_movie_title

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val textView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)

        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMovieTitle.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size
}