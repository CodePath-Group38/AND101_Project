package com.example.mealmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class RecipesActivity : AppCompatActivity() {
    var link = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        val intent = intent
        link = intent.getStringExtra("link").toString()

        getMealListURL()


    }

    private fun getMealListURL() {

        val client = AsyncHttpClient()


        client[link, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Food", "response successful$json")

                Toast.makeText(applicationContext, "searching", Toast.LENGTH_SHORT).show()

                val linkText = findViewById<TextView>(R.id.linkText)

                linkText.text = link.toString()








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