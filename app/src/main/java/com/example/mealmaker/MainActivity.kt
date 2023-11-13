package com.example.mealmaker

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
    private val diet = arrayOf("Diet", "Balanced", "High Fiber", "High Protein", "Low Carb", "Low Fat")
    private val cuisine = arrayOf("Cuisine", "American", "Asian", "Chinese", "French", "Italian", " Mexican")
    private val meal = arrayOf("Meal Type", "Breakfast", "Lunch", "Dinner")
    private var dietType = ""
    private var cuisineType = ""
    private var mealType = ""
    private val dietList = mapOf(
        "Balanced" to "&diet=balanced",
        "High Fiber" to "&diet=high-fiber",
        "High Protein" to "&diet=high-protein",
        "Low Carb" to "&diet=low-carb",
        "Low Fat" to "&diet=low-fat"
    )

    private val cuisineList = mapOf(
        "American" to  "&cuisineType=american",
        "Asian" to "&cuisineType=asian",
        "Chinese" to "&cuisineType=chinese",
        "French" to "&cuisineType=french",
        "Italian" to "&cuisineType=italian",
        "Mexican" to "&cuisineType=mexican",
    )

    private val mealList = mapOf(
        "Breakfast" to "&mealType=breakfast",
        "Lunch"  to "&mealType=lunch" ,
        "Dinner" to "&mealType=dinner"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item1 = findViewById<Spinner>(R.id.diet)
        val arrayAdapter = CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,diet)
        item1.adapter = arrayAdapter
        item1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                dietType = item1.selectedItem.toString()

                if (p2 != 0) {
                    dietType = dietList[dietType].toString()
                    Toast.makeText(applicationContext, dietType, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val item2 = findViewById<Spinner>(R.id.cuisine)
        val arrayAdapter2 = CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cuisine)
        item2.adapter = arrayAdapter2
        item2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                cuisineType = item2.selectedItem.toString()
                if (p2 != 0) {
                    cuisineType = cuisineList[cuisineType].toString()
                    Toast.makeText(applicationContext, cuisineType, Toast.LENGTH_LONG).show()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val item3 = findViewById<Spinner>(R.id.meal)
        val arrayAdapter3 = CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,meal)
        item3.adapter = arrayAdapter3
        item3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                mealType = item3.selectedItem.toString()
                if (p2 != 0) {
                    mealType = mealList[mealType].toString()
                    Toast.makeText(applicationContext, mealType, Toast.LENGTH_LONG).show()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val searchButton = findViewById<TextView>(R.id.search)
        searchButton.setOnClickListener{
            showResult()

            parseIngr()

            link = "https://api.edamam.com/api/recipes/v2?type=public&q=$ingList&app_id=$id&app_key=$key$dietType$health$cuisineType$mealType"

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
    class CustomArrayAdapter(context: Context, layout: Int, list: Array<String>) : ArrayAdapter<String>(context, layout, list) {
//        override fun isEnabled(position: Int): Boolean {
//            // Disable the first item from Spinner
//            // First item will be used for hint
//            return position != 0
//        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getDropDownView(position, convertView, parent)
            val tv = view as TextView
            if (position == 0) {
                // Set the hint text color gray
                tv.setTextColor(Color.GRAY)
            }
            return view
        }
    }

}