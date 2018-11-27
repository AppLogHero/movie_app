package com.example.applog.movielist.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "Title") var title: String,
    @ColumnInfo(name = "Runtime") var runtime: String,
    @ColumnInfo(name = "Description") var description: String
){
    constructor():this(null,"","","")
}