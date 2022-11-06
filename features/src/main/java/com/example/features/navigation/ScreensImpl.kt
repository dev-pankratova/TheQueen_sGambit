package com.example.features.navigation

import com.example.common.entities.MealItem
import com.example.common.navigation.Screens
import com.example.features.screens.auth.AuthFragment
import com.example.features.screens.busket.BasketFragment
import com.example.features.screens.main.MainFragment
import com.example.features.screens.meals.SetMealPlanFragment
import com.example.features.screens.meals.SetMealPlanFragment2
import com.example.features.screens.personal_info.InputPersonalInfoFragment
import com.example.features.screens.product.ProductFragment
import com.example.features.screens.registration.RegistrationFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreensImpl : Screens {

    override fun authScreen() = FragmentScreen { AuthFragment() }

    override fun registrationScreen() = FragmentScreen { RegistrationFragment() }

    override fun setMealPlanScreen() = FragmentScreen { SetMealPlanFragment() }

    override fun setMealPlanScreen2() = FragmentScreen { SetMealPlanFragment2() }

    override fun product(meal: MealItem) = FragmentScreen { ProductFragment.getInstance(meal) }

    override fun inputPersonalInfoScreen() = FragmentScreen { InputPersonalInfoFragment() }

    override fun mainScreen() = FragmentScreen { MainFragment() }

    override fun basketScreen(meal: MealItem) = FragmentScreen { BasketFragment.getInstance(meal) }

}