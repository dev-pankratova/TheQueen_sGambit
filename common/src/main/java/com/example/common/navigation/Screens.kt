package com.example.common.navigation

import com.example.common.entities.MealItem
import com.github.terrakok.cicerone.Screen

interface Screens {

    fun authScreen(): Screen

    fun registrationScreen(): Screen

    fun setMealPlanScreen(): Screen

    fun setMealPlanScreen2(): Screen

    fun product(meal: MealItem): Screen

    fun inputPersonalInfoScreen(): Screen

    fun mainScreen(): Screen

    fun basketScreen(meal: MealItem): Screen

}