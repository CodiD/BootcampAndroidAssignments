package com.isabelledionisius.myomelettapp.omeletts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isabelledionisius.myomelettapp.R
import com.isabelledionisius.myomelettapp.omelettdetails.DetailActivity
import com.isabelledionisius.myomelettapp.omeletts.list.OmelettAdapter
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett

/** Main activity of the list page
 *
 */

abstract class MainActivity : AppCompatActivity(),
    OmelettAdapter.OmelettListClickListener {

    private lateinit var omelettListRecyclerView: RecyclerView
    private val omelettDataManager =
        OmelettAdapter(this)

    companion object {
        const val INTENT_LIST_KEY = "list"
    }

    /**
     * Creating the adapter and assigning the values to it
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        omelettListRecyclerView = findViewById(R.id.recycler_view)
        omelettListRecyclerView.layoutManager = LinearLayoutManager(this)
//        omelettListRecyclerView.adapter =
//            OmelettAdapter(this)
    }

    /**
     * This method will open the new activity passing the tasklist objects to it
     * we are passing in the context which is the activity to the Intent => "this"
     * then we are addressing the new class
     */

    private fun showDetailOmelettItems(list: Omelett) {
        val detailMovieItem = Intent(this, DetailActivity::class.java)
        detailMovieItem.putExtra(INTENT_LIST_KEY, list)
        startActivity(detailMovieItem)
    }

    /**
     * When a row is clicked details are being triggered
     */
    override fun omelettListItemClicked(omelett: Omelett) {
        showDetailOmelettItems(omelett)
    }

    operator fun invoke(omelett: Omelett) {

    }
}