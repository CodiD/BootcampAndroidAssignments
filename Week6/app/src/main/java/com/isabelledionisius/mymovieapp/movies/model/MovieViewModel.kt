package com.isabelledionisius.mymovieapp.movies.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.isabelledionisius.mymovieapp.repository.MovieRepository
import com.isabelledionisius.mymovieapp.db.MovieDataList
import com.isabelledionisius.mymovieapp.db.MovieRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MovieRepository
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val movieItems: LiveData<List<MovieDataList>>

    init {
        val movieDao = MovieRoomDatabase.getDatabase(application).wordDao()
        repository =
            MovieRepository(movieDao)
        movieItems = movieDao.getMovieItems()
    }
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    suspend fun insert(movieItems: MovieDataList) {
        // IO dispatcher as a context argument
        // the dipatcher is used to define threads for coroutines
        // context in general is a set of rules
        coroutineScope {
            launch (context = Dispatchers.IO) {
            repository.movieRepository.insert(movieItems)
            // posting back to the main thread
            launch(Dispatchers.Main) {
            }
           }
        }.cancel()
    }
}