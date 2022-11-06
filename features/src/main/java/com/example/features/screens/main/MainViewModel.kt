package com.example.features.screens.main

import com.example.common.base.BaseViewModel
import com.example.common.entities.MealItem
import com.example.common.storage.registeredUser
import kotlin.math.sign

class MainViewModel : BaseViewModel() {

    fun provideRecommendedMeals(): List<MealItem> {
        val handledMeals = mutableListOf<MealItem>()
        if (registeredUser == null || (registeredUser != null && registeredUser?.allergens.isNullOrEmpty())) {
            handledMeals.addAll(recommendedMeals)
        }
        recommendedMeals.forEach {
            if (registeredUser?.allergens?.contains(it.allergen) == false) {
                handledMeals.add(it)
            }
        }
        return handledMeals
    }

    fun provideCategories(): List<MealItem> {
        return categories
    }

    fun onOpenMealDetails(mealItem: MealItem) {
        router.navigateTo(screens.product(mealItem))
    }

    fun onOpenBasketScreen(mealItem: MealItem) {
        router.navigateTo(screens.basketScreen(mealItem))
    }
}