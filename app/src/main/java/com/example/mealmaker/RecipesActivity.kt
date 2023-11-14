package com.example.mealmaker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers


class RecipesActivity : AppCompatActivity() {
    var link = ""
    private lateinit var recipeRecView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        recipeRecView = findViewById<RecyclerView>(R.id.recipe_RecycleView)

        val intent = intent
        link = intent.getStringExtra("link").toString()

        getMealListURL()

    }


    private fun getMealListURL() {
        val client = AsyncHttpClient()
        client[link, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {

                val recipeModelArrayList: ArrayList<RecipeModel> = ArrayList<RecipeModel>()
                val arr = json.jsonObject.getJSONArray("hits")

                for(i in 0 until arr.length()) {
                    var eleObj = arr.getJSONObject(i)
                    var recipeObj = eleObj.getJSONObject("recipe")

                    var name = recipeObj.getString("label").toString()
                    var img = recipeObj.getString("image").toString()

                    recipeModelArrayList.add(RecipeModel(name, "temp test", img))
                }

                val recipeAdapter = RecipeAdapter(recipeModelArrayList)

                val linearLayoutManager = LinearLayoutManager(this@RecipesActivity, LinearLayoutManager.VERTICAL, false)
                recipeRecView.layoutManager = linearLayoutManager
                recipeRecView.adapter = recipeAdapter
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