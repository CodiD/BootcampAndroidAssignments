package com.isabelledionisius.mymovieapp.repository

import androidx.lifecycle.LiveData
import com.isabelledionisius.mymovieapp.db.DaoMovie
import com.isabelledionisius.mymovieapp.db.MovieDataList

class MovieRepository(private val movieDao: DaoMovie) {

    var movieRepository =
        MovieRepository(
            movieDao
        )

    // Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
    class MovieRepository(private val movieDao: DaoMovie) {

        // Room executes all queries on a separate thread.
        // Observed LiveData will notify the observer when the data has changed.
        val allInfos: LiveData<List<MovieDataList>> = movieDao.getMovieItems()

        suspend fun insert(
            newMovie: MovieDataList
        ) {
            movieDao.insert(newMovie)
        }
    }
}