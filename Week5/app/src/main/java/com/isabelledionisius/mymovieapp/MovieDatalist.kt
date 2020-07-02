package com.isabelledionisius.mymovieapp


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="datalist")

class MovieDataList(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "releaseDate") val releaseDate: String,

    @ColumnInfo(name = "title") val title: String,

    @ColumnInfo(name = "summary") val summary: String,


    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "poster") val poster: Int
)




