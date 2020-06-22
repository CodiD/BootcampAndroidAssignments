package com.isabelledionisius.mymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    /**
     * properties to be displayed in the detail view
     */
    lateinit var movies:Movie
    lateinit var summary:TextView
    lateinit var movieName:TextView
    lateinit var moviePoster:ImageView

    /**
     * Assigning the values to the properties fields
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        movies = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as Movie
        title = movies.title
        moviePoster = findViewById(R.id.image)
        movieName = findViewById(R.id.title)
        summary = findViewById(R.id.summary)
        movieName.text = movies.title
        summary.text = movies.summary
        moviePoster.setImageResource(movies.poster)


    }
}