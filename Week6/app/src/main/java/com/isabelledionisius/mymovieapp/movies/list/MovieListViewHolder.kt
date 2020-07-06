package com.isabelledionisius.mymovieapp.movies.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.isabelledionisius.mymovieapp.R

// passing itemview to the superclass constructor
class MovieListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    /**
     * View holder items for MovieAdapter class
     */
    var titleTextView = itemView.findViewById<TextView>(R.id.title)
    var genreTextView = itemView.findViewById<TextView>(R.id.genre)
    var posterImageView = itemView.findViewById<ImageView>(R.id.image)
}