package com.example.mealmaker

class RecipeModel (var recipe_name: String, var recipe_rating: Int, var recipe_image: String) {
    fun getRecipe_name(): String {
        return recipe_name
    }

    fun setRecipe_name(recipe_name: String) {
        this.recipe_name = recipe_name
    }

    fun getRecipe_rating(): Int {
        return recipe_rating
    }

    fun setRecipe_rating(recipe_rating: Int) {
        this.recipe_rating = recipe_rating
    }

    fun getRecipe_image(): String {
        return recipe_image
    }

    fun setRecipe_image(recipe_image: String) {
        this.recipe_image = recipe_image
    }
}