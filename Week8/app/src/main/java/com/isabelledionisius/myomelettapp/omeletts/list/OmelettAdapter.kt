package com.isabelledionisius.myomelettapp.omeletts.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isabelledionisius.myomelettapp.R
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett

class OmelettAdapter(val omeletts: List<Omelett>, private val onOmelettClicked: (Omelett)->Unit):
      RecyclerView.Adapter<OmelettListViewHolder>(){
    /**
     * User clicks on one row
     */
    interface OmelettListClickListener {
        fun omelettListItemClicked(omelett: Omelett)
    }

    /**
     * View holder is being bcreated
     * @ returns OmelettListHolder
     */
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OmelettListViewHolder {
        val view = LayoutInflater.from(parent.context)// the method from takes the parents context
         // creating a view
            .inflate(R.layout.omelett_list_holder,parent,false)
        // now that we have created the view we have to create the viewholder from it
        // the view holder takes in the view that we have just inflated
        return OmelettListViewHolder(view)
    }
    /**
     * returns the movie objects
     */
    fun getList():List<Omelett> {
        return omeletts
    }

    /**
     * determines the size off the array
     */
    override fun getItemCount(): Int {
        return omeletts.size
    }
    // this method displays the content
 override fun onBindViewHolder(holder: OmelettListViewHolder, position: Int) {
        holder.bind(omeletts[position], onOmelettClicked)
    }
}