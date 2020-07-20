package com.isabelledionisius.myomelettapp.networking

import com.google.gson.GsonBuilder
import com.isabelledionisius.myomelettapp.omeletts.model.Omelett
import com.isabelledionisius.myomelettapp.omeletts.model.response.Success
import okhttp3.*
import java.io.IOException


/**
 * Holds decoupled logic for all the API calls.
 */

const val BASE_URL = "http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet"

class RemoteApi(val completion: (List<Omelett>) -> Unit) {
    suspend fun getOmelettIngredients() {
        val request = Request.Builder().url(BASE_URL).build()
        val client = OkHttpClient()
        client.newCall(request = request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val response = gson.fromJson(body, GetRecipeResponse::class.java)
                completion(response.results)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Fail with $e")
            }
        })

    }
}

class GetRecipeResponse(val results: List<Omelett>)
