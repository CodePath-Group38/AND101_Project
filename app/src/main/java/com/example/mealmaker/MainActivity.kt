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
    private val id = "72a9a585"
    private val key = "b2bc0b595313e8d3dcbda591d057ab41"
    private val health = "&health=gluten-free"
    private var ingr = "chicken"
    private var ingList = ""
    private var link = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchButton = findViewById<TextView>(R.id.search)
        searchButton.setOnClickListener{
            showResult()

            parseIngr()

            link = "https://api.edamam.com/api/recipes/v2?type=public&q=$ingList&app_id=$id&app_key=$key$health"

            val intent = Intent(this, RecipesActivity::class.java)

            intent.putExtra("link", link)
            startActivity(intent)


        }



    }

    private fun getMealListURL() {

        val client = AsyncHttpClient()


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
        ingList = word.joinToString("%20")

    }

    private fun showResult(){

        val ingText = findViewById<EditText>(R.id.ingr)
        ingr = ingText.text.toString()

        parseIngr()

    }
}