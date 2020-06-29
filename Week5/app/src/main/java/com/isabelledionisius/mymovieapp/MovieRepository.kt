package com.isabelledionisius.mymovieapp

import androidx.lifecycle.LiveData

class MovieRepository(private val movieDao: DaoMovie) {

    var wordRepository = WordRepository(movieDao)

    // Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
    class WordRepository(private val movieDao: DaoMovie) {

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