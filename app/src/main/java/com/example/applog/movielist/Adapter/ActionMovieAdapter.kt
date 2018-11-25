package com.example.applog.movielist.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.applog.movielist.R
import kotlinx.android.synthetic.main.action_movie_list_item.view.*
import kotlinx.android.synthetic.main.movie_list_item.view.*

class ActionMovieAdapter(private val myDataset: ArrayList<String>) :
    RecyclerView.Adapter<ActionMovieAdapter.ActionMovieViewHolder>() {

    class ActionMovieViewHolder(val view: View, context: Context) : RecyclerView.ViewHolder(view) {

        val imageView = view.action_movie_imageview

        //val tvMovieTitle = view.tv_movie_title

        val theSuperContext = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionMovieViewHolder {

        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.action_movie_list_item, parent, false)

        return ActionMovieViewHolder(cellForRow, parent.context)
    }

    override fun onBindViewHolder(holder: ActionMovieViewHolder, position: Int) {
        //holder.tvMovieTitle.text = myDataset[position]

        Glide.with(holder.theSuperContext)
            .load("https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg")
            .into(holder.imageView)
    }

    override fun getItemCount() = myDataset.size

}