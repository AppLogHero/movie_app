package com.example.applog.movielist.DataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.applog.movielist.DAO.MovieEntityDAO
import com.example.applog.movielist.Entity.MovieEntity

@Database(entities = arrayOf(MovieEntity::class), version = 1, exportSchema = false)
abstract class MovieDataBase: RoomDatabase() {

    abstract fun movieDao(): MovieEntityDAO

    companion object {
        private var sInstance: MovieDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MovieDataBase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, MovieDataBase::class.java, "movie.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }

}