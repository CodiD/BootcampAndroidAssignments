package com.isabelledionisius.mymovieapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoMovie {

    @Query("SELECT * from datalist ORDER BY id ASC")
    fun getMovieItems(): LiveData<List<MovieDataList>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(newMovie: MovieDataList)

    @Query("DELETE FROM datalist")
    suspend fun deleteAll()

}









