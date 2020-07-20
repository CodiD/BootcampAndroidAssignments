package com.isabelledionisius.myomelettapp.omeletts.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.isabelledionisius.myomelettapp.repository.OmelettRepository
import com.isabelledionisius.myomelettapp.db.OmelettDataList
import com.isabelledionisius.myomelettapp.db.OmelettRoomDatabase
import com.isabelledionisius.myomelettapp.omeletts.model.response.OmelettData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class OmelettViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: OmelettRepository
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val omelettItems: LiveData<List<OmelettDataList>>

    init {
        val omelettDao = OmelettRoomDatabase.getDatabase(application).omelettDao()
        repository =
            OmelettRepository(omelettDao)
        omelettItems = omelettDao.getOmelettItems()
    }
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    suspend fun insert(omelettItems: OmelettData) {
        // IO dispatcher as a context argument
        // the dipatcher is used to define threads for coroutines
        // context in general is a set of rules
        coroutineScope {
            launch (context = Dispatchers.IO) {
           // repository.omelettRepository.insert(omelettItems)
            // posting back to the main thread
            launch(Dispatchers.Main) {
            }
           }
        }.cancel()
    }
}