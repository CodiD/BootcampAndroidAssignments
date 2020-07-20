package com.isabelledionisius.myomelettapp.networking

import retrofit2.Call
import retrofit2.http.GET
import com.isabelledionisius.myomelettapp.omeletts.model.response.*

/*
Holds the API class for the Omelett Ingredients app
 */
interface RemoteApiService {

    @GET("api")
    suspend fun getOmelettIngredients(): Call<DataResult>
}