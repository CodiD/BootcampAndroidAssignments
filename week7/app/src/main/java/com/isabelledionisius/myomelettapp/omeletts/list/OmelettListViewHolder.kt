package com.isabelledionisius.myomelettapp.omeletts.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.isabelledionisius.myomelettapp.omeletts.MainActivity
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett
import kotlinx.android.synthetic.main.activity_detail.view.*

// passing itemview to the superclass constructor
class OmelettListViewHolder(val containerView: View): RecyclerView.ViewHolder(containerView) {
    /**
     * View holder items for MovieAdapter class
     */

    fun bind(omelett: Omelett, onOmelettClick: MainActivity) = with(containerView) {
        titleTextView.text = omelett.title
        image.setImageResource(omelett.image)
        rootView.setOnClickListener { onOmelettClick(omelett) }
    }
}

