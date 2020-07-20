package com.isabelledionisius.myomelettapp.repository

import androidx.lifecycle.LiveData
import com.isabelledionisius.myomelettapp.db.DaoOmelett
import com.isabelledionisius.myomelettapp.db.OmelettDataList
import com.isabelledionisius.myomelettapp.omeletts.model.response.OmelettData

    class OmelettRepository(private val omelettDao: DaoOmelett) {

        // Room executes all queries on a separate thread.
        // Observed LiveData will notify the observer when the data has changed.
        val allInfos: LiveData<List<OmelettDataList>> = omelettDao.getOmelettItems()
        suspend fun insert(
            newOmelett: OmelettData
        ) {
            omelettDao.insert(newOmelett)
        }
    }
