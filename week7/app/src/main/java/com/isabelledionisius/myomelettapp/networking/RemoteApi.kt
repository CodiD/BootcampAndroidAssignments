package com.isabelledionisius.myomelettapp.networking

import com.isabelledionisius.myomelettapp.omeletts.model.response.*


/**
 * Holds decoupled logic for all the API calls.
 */

const val BASE_URL = "http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet"

class RemoteApi(private val apiService: RemoteApiService) {


    suspend fun getOmelettIngredients(): Failure = try
    {
        val data = apiService.getOmelettIngredients()
        Success(data)
    } catch (error:Throwable)
    {
        Failure(error)

    } as Failure


}