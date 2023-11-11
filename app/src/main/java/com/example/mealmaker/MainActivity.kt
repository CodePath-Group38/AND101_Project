package com.example.mealmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val id = "72a9a585"
    val key = "b2bc0b595313e8d3dcbda591d057ab41"
    val health = "&health=gluten-free"
    val ingr = "chicken%20potato"

    val link = "https://api.edamam.com/api/recipes/v2?type=public&q=$ingr&app_id=$id&app_key=$key$health"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMealListURL()
    }

    private fun getMealListURL() {

        val client = AsyncHttpClient()

        client[link, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Food", "response successful$json")



            }
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Recipe Error", errorResponse)
            }
        }]

    }
}