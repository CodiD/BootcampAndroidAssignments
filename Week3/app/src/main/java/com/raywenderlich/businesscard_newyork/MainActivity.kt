package com.raywenderlich.businesscard_newyork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //cleaning the code
    lateinit var tipText: TextView
    lateinit var tipButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tipText = findViewById(R.id.t_tip)
        tipButton = findViewById(R.id.b_tip)

        tipButton.setOnClickListener { view->
            tipText.text = getTip()
        }


    }
    // this function pulls a random tip
    fun getTip(): String {
        var randomTip = " "
        var tips = arrayOf(
            "Eat a delicious Hot Pot in Little Sheep",
            "Run a race in the Central Park",
            "Have an English Tea in Alice's Tea Cup",
            "Paddle around the Hudson",
            "Have a free outdoor concert at Yonker's waterfront",
            "Hang out at Orchard Beach and play Basketball",
            "Have a cocktail in City Island"
        )
        randomTip = tips.random()
        return randomTip

    }
}