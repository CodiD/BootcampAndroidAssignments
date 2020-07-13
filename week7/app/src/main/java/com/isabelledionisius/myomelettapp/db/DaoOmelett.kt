package com.isabelledionisius.myomelettapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.isabelledionisius.myomelettapp.omeletts.model.response.OmelettData

@Dao
interface DaoOmelett {

    @Query("SELECT * from datalist ORDER BY id ASC")
    fun getOmelettItems(): LiveData<List<OmelettDataList>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(newOmelett: OmelettData)

    @Query("DELETE FROM datalist")
    suspend fun deleteAll()
}









