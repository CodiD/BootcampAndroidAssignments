package com.isabelledionisius.myomelettapp.omeletts.list

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.isabelledionisius.myomelettapp.R
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_detail.view.image
import kotlinx.android.synthetic.main.omelett_list_holder.view.*

// passing itemview to the superclass constructor
class OmelettListViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),LayoutContainer {
    /**
     * View holder items for MovieAdapter class
     */
    fun bind(omelett: Omelett, onOmelettClick: (Omelett) -> Unit) = with(containerView) {
        containerView.title.text = omelett.title
        if (omelett.thumbnail != null && omelett.thumbnail!!.isNotEmpty()) {
            Picasso.get().load(omelett.thumbnail).into(containerView.image)// downloading images from the api
        } else {
            image.setImageResource(R.drawable.omelett_default)
        }
        rootView.setOnClickListener { onOmelettClick(omelett) }
    }
}

