package com.isabelledionisius.myomelettapp.omeletts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.*
import com.isabelledionisius.myomelettapp.R
import com.isabelledionisius.myomelettapp.networking.RemoteApi
import com.isabelledionisius.myomelettapp.omelettdetails.DetailActivity
import com.isabelledionisius.myomelettapp.omeletts.list.OmelettAdapter
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett
import com.isabelledionisius.myomelettapp.worker.PeriodicWorker
import androidx.work.PeriodicWorkRequestBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


/** Main activity of the list page
 *
 */
class MainActivity : AppCompatActivity(),
    OmelettAdapter.OmelettListClickListener {

 private lateinit var omelettListRecyclerView: RecyclerView

    companion object {
        const val INTENT_LIST_KEY = "list"
    }

    /**
     * Creating the adapter and assigning the values to it
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        omelettListRecyclerView = this.recycler_view//findViewById(R.id.recycler_view)
        omelettListRecyclerView.layoutManager = LinearLayoutManager(this)
        getData()
        synchronizeData()
    }

    private fun getData() {
        GlobalScope.launch {
            RemoteApi(completion = {
                val adapter = OmelettAdapter(it, onOmelettClicked = { selected ->
                    showDetailOmelettItems(selected)
                })
                runOnUiThread {
                    omelettListRecyclerView.adapter = adapter
                }
            }).getOmelettIngredients()
        }
    }

     /**
     * This method will open the new activity passing the tasklist objects to it
     * we are passing in the context which is the activity to the Intent => "this"
     * then we are addressing the new class
     */
    private fun showDetailOmelettItems(list: Omelett) {
        val detailOmelettItem = Intent(this, DetailActivity::class.java)
        detailOmelettItem.putExtra(INTENT_LIST_KEY, list)
        startActivity(detailOmelettItem)
    }

    /**
     * When a row is clicked details are being triggered
     */
    override fun omelettListItemClicked(omelett: Omelett) {
        showDetailOmelettItems(omelett)
    }

    private fun synchronizeData() {
        // setting the constraints for the periodic work
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        // building periodic work request
        val work = PeriodicWorkRequestBuilder<PeriodicWorker>(1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        val logBuilder = PeriodicWorkRequestBuilder<PeriodicWorker>(
            30, TimeUnit.MINUTES,
            15, TimeUnit.MINUTES
        )

        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(work)
        showSynchronizationMessage()
    }

    fun showSynchronizationMessage() {
        val toast = Toast.makeText(applicationContext, SYNCHRONIZATION_MESSAGE, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()
    }
}
private const val SYNCHRONIZATION_MESSAGE = "Data is being synchronized"

