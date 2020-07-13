package com.isabelledionisius.myomelettapp.omeletts.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.isabelledionisius.myomelettapp.R
import com.isabelledionisius.myomelettapp.omeletts.MainActivity
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett

class OmelettAdapter(private val onOmelettClicked: MainActivity)   {
    /**
     * User clicks on one row
     */
    interface OmelettListClickListener {
        fun omelettListItemClicked(omelett: Omelett)
    }

    private val omeletts = arrayOf<Omelett>()

    /**
     * View holder is being bcreated
     * @ returns OmelettListHolder
     */
 fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OmelettListViewHolder {
        val view = LayoutInflater.from(parent.context)// the method from takes the parents context
         // creating a view
            .inflate(R.layout.omelett_list_holder,parent,false)
        // now that we have created the view we have to create the viewholder from it
        // the view holder takes in the view that we have just inflated
        return OmelettListViewHolder(
            view
        )
    }
    /**
     * returns the movie objects
     */
    fun getList():Array<Omelett> {
        return omeletts
    }

    /**
     * determines the size off the array
     */
    fun getItemCount(): Int {
        return omeletts.size
    }
    // this method displays the content
 fun onBindViewHolder(holder: OmelettListViewHolder, position: Int) {

        holder.bind(omeletts[position], onOmelettClicked)

    }
}