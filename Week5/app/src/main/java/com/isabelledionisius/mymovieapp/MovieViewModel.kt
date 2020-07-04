package com.isabelledionisius.mymovieapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MovieRepository

    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val movieItems: LiveData<List<MovieDataList>>

    init {
        val movieDao = MovieRoomDatabase.getDatabase(application).wordDao()
        repository = MovieRepository(movieDao)
        movieItems = movieDao.getMovieItems()
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(movieItems: MovieDataList) {
        GlobalScope.launch (Dispatchers.Main) {
            repository.wordRepository.insert(movieItems)
        }


    }
}