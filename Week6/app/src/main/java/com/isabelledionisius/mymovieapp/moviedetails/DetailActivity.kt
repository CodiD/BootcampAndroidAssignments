package com.isabelledionisius.mymovieapp.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.isabelledionisius.mymovieapp.movies.MainActivity
import com.isabelledionisius.mymovieapp.movies.model.Movie
import com.isabelledionisius.mymovieapp.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    /**
     * properties to be displayed in the detail view
     */
    lateinit var movies: Movie

    /**
     * Assigning the values to the properties fields
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        assigningValues()
    }

    fun assigningValues() {
        movies = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as Movie
        title = movies.title
        tvTitle.text = movies.title
        etSummary.setText(movies.summary)
        image.setImageResource(movies.poster)
    }
}