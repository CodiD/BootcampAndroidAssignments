package com.isabelledionisius.mymovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** Main activity of the list page
 *
 *
 */

class MainActivity : AppCompatActivity(),MovieAdapter.MovieListClickListener {

    private lateinit var movieListRecyclerView: RecyclerView
    private var movieDataManager = MovieAdapter(this)

    companion object {
        const val INTENT_LIST_KEY = "list"
    }

    /**
     * Creating the adapter and assigning the values to it
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieListRecyclerView = findViewById(R.id.recycler_view)
        movieListRecyclerView.layoutManager = LinearLayoutManager(this)


        movieListRecyclerView.adapter = MovieAdapter(this)
        //showDetailMovieItems(movieDataManager.getList())
    }

    /**
     * This method will open the new activity passing the tasklist objects to it
     * we are passing in the context which is the activity to the Intent => "this"
     * then we are addressing the new class
     * -- check the parameter if that is the correct one: in the examle: list:TaskList
     */
    private fun showDetailMovieItems(list: Movie) {
        val detailMovieItem = Intent(this, DetailActivity::class.java)
        // adding an extra
        detailMovieItem.putExtra(INTENT_LIST_KEY, list)
        startActivity(detailMovieItem)
    }

    /**
     * When a row is clicked details are being triggered
     */
    override fun movieListItemClicked(movie: Movie) {
        showDetailMovieItems(movie)


    }
}