package com.example.applog.movielist.DAO

import android.arch.persistence.room.*
import com.example.applog.movielist.Entity.MovieEntity
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface MovieEntityDAO {

    @Query("SELECT * FROM Movie")
    fun selectAll(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieData: MovieEntity)

    @Delete
    fun deleteMovie(movieData: MovieEntity)

}