package com.isabelledionisius.myomelettapp.omelettdetails

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isabelledionisius.myomelettapp.omeletts.MainActivity
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett
import com.isabelledionisius.myomelettapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*

class DetailActivity : AppCompatActivity() {
    /**
     * properties to be displayed in the detail view
     */
    lateinit var omeletts: Omelett

    /**
     * Assigning the values to the properties fields
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        assigningValues()
    }

    fun assigningValues() {
        omeletts = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as Omelett
        title = omeletts.title
        titleTextView.text = omeletts.title
        ingredientsEditText.setText(omeletts.ingredients)
        if (omeletts.thumbnail != null && omeletts.thumbnail!!.isNotEmpty()) {
            Picasso.get().load(omeletts.thumbnail).into(image)
        } else {
            image.setImageResource(R.drawable.omelett_default)
        }
    }
}