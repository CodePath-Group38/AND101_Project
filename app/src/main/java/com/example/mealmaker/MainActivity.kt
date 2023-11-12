package com.example.mealmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
    var ingr = ""
    val ingList = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchButton = findViewById<TextView>(R.id.search)
        searchButton.setOnClickListener{
            showResult()

            val intent = Intent(this, RecipesActivity::class.java)

            startActivity(intent)


        }



    }

    private fun getMealListURL() {

        val client = AsyncHttpClient()
        parseIngr()
        val link = "https://api.edamam.com/api/recipes/v2?type=public&q=$ingList&app_id=$id&app_key=$key$health"
        client[link, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Food", "response successful$json")

                Toast.makeText(applicationContext, "searching", Toast.LENGTH_LONG).show()



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

    private fun parseIngr(){
        val word = ingr.split(", ", " ")
        val ingList = word.joinToString("%20")

    }

    private fun showResult(){
        parseIngr()
        val ingText = findViewById<EditText>(R.id.ingr)
        ingr = ingText.text.toString()
        getMealListURL()

    }
}