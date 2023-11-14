package com.example.mealmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(recipeModelArrayList: ArrayList<RecipeModel>):
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private val recipeModelArrayList: ArrayList<RecipeModel>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImg: ImageView
        val recipeName: TextView
        val recipeRate: TextView
        init {
            recipeImg = itemView.findViewById(R.id.recipe_pic)
            recipeName = itemView.findViewById(R.id.recipe_name)
            recipeRate = itemView.findViewById(R.id.rating)
        }
    }

    init {
        this.recipeModelArrayList = recipeModelArrayList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: RecipeModel = recipeModelArrayList[position]
        holder.recipeName.setText(model.getRecipe_name())
        holder.recipeRate.setText("" + model.getRecipe_rating())

        Glide.with(holder.recipeImg.context)
            .load(model.getRecipe_image())
            .into(holder.recipeImg)

    }

    override fun getItemCount(): Int {
        return recipeModelArrayList.size
    }


}