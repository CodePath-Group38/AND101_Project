# **Meal Maker**
<img src='https://i.imgur.com/spqjwnm.jpg' title='App Logo' width='300' alt='AppLogo'/>

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

**Meal Maker is a smart and easy-to-use app that helps you find the best recipes for your ingredients, diet, cuisine, and meal type. All you have to do is:**

- **Enter the ingredients you have or want to use**
- **Select your diet type (balanced, high-fiber, high protein, low carb)**
- **Choose your cuisine type (American, Asian, Italian, Mexican, Indian)**
- **Pick your meal type (breakfast, lunch, or dinner)**

**Meal Maker will then search through thousands of recipes from various sources and show you the most suitable ones for your criteria.**

### App Evaluation

<!-- Evaluation of your app across the following attributes -->
- **Category:** Food & Eating / Lifestyle Health & Fitness
- **Mobile:** The mobile app allows users to find recipes based on the ingredients they have on hand. People usually use their phones to find and follow recipes while cooking. The app also shows the calories and nutritional values for each meal.
- **Story:** Allows people to easily find recipes they can follow with the ingredients that they already have. The app also provides the calories and nutriotional value of the meal. People can explore more quick recipes on ingredients that the user already has at home. This way they do not need to spend time reading long articles or cookbooks online or even watching videos which take some time to do. They can immediately start cooking. The calories and nutritional content can also provide immediate feedback given the user's lifestyle, which neither articles online or videos can predict or help the user in managing. Ingredients can be added or dropped to also reduce calories in real time. 
- **Market:** Home chefs and cooks, as well as professional chefs could use this. Even food pantries and soup kitchens could make use of this app too. Those who want to start to learn how to cook as well as young adults would want to give it a try.
- **Habit:** Those that want to learn more and perfect the craft of cooking will want to come back to learn more recipes over time. Those that enjoy the recipes and the resourcefulness of cooking with what ingredients you have will also incentivize using the app more. 
- **Scope:** V1 could be adding ingredients as well as recipes. V2 could add what recipes can you make with what ingredients currently. V3 could add support with calorie tracker as well as users customizing recipes and saving them as a modified recipe and maybe even republishing them.

## Product Spec

### 1. User Features (Required and Optional)

Required Features:

- **User can search for ingredients and recipes**
- **User can filter by calorie amount**
- **User can filter by cuisine type and ingredients they have**
- **Users can save recipes**
- **Users can filter by nutrient needs like carbs or protein**

Stretch Features:

- **User can subtract or add ingredients to recipes or even make their own**
- **User can see the prices of ingredients and the cheapest at which store**
- **User can account for how many calories they have burned or exercised away, as well as their bmi, age, and other factors which will tell them how many calories they need and the nutrients throughout the day**
- **User can choose to plan out 3 meals with ingredients or recipes, and the app can remind them to eat throughout the day while showing them which recipes they have saved or want to eat**


### 2. Chosen API(s)

- **[EDAMAN API](https://developer.edamam.com/edamam-docs-recipe-api)**
  - Get recipes
      - User can search for recipes based on ingredients
      - User can filter result by diet, cuisine, and meal type
  - Get calories/nutritional value
      - User can see the nutritional value for each meal
      - User can see the calorie value for each recipe


### 3. User Interaction

Required Feature

- **In the textbox, ingredient is searched**
  - => **scrollable list appears, user can tap to add ingredient (or manually add ingredients into a list)**
- **User taps [Generate Recipes] button**
  - => **recipes that include all ingredients listed by user pops up**
- **User taps dropdown for cuisine type**
  - => **Dropdown of different global cuisine types show up, if user presses, recipes will only show based on cuisine type**
- **Taps recipe**
  - => **Recipe calorie, and ingredients are listed as well as nutritional data**
- **Save recipe**
  - => **saves recipe for user to reference later**

## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://i.imgur.com/Kt0TaYn.png" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  


For Milestone 2, include **2+ Videos/GIFs** of the build process here!

Our first build process where we properly swapped to a new activity when on button press, as well as retrieving the correct URL link. 
<img src='https://github.com/CodePath-Group38/AND101_Project/blob/main/imp_1.gif' title='Video Demo' width='' alt='Video Demo' />

Our second build process included adding features to warn the user, such as requiring them to enter an ingredient to search, as well as having the spinners and drop down menus working for appending more queries to the search URL link.
<img src='https://github.com/CodePath-Group38/AND101_Project/blob/main/imp_2.gif' title='Video Demo' width='' alt='Video Demo' />

Our third build process made the "random" button working to grab a random ingredient to search for recipes, as well as fully implementing the recycler view and touch ups to the app's fonts and color.

<img src='https://github.com/CodePath-Group38/AND101_Project/blob/main/imp_recV.gif' title='Video Demo' width='' alt='Video Demo' />

## License

Copyright **Carlos Sac & Zhihua Zhu** 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
