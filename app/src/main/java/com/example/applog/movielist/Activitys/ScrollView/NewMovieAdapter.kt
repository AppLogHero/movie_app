package com.example.applog.movielist.Activitys.ScrollView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.movie_list_item.view.*

class NewMovieAdapter(private val myDataset: ArrayList<String>) :
    RecyclerView.Adapter<NewMovieAdapter.NewMovieViewHolder>() {

    class NewMovieViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvMovieTitle = view.tv_movie_title

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieViewHolder {

        val textView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)

        return NewMovieViewHolder(textView)
    }

    override fun onBindViewHolder(holder: NewMovieViewHolder, position: Int) {
        holder.tvMovieTitle.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size
}