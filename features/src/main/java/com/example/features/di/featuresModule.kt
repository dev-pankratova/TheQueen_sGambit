package com.example.features.di

import com.example.common.base.BaseViewModel
import com.example.common.navigation.Screens
import com.example.features.navigation.ScreensImpl
import com.example.features.screens.auth.AuthViewModel
import com.example.features.screens.busket.BasketViewModel
import com.example.features.screens.main.MainViewModel
import com.example.features.screens.meals.SetMealPlanViewModel
import com.example.features.screens.personal_info.InputPersonalViewModel
import com.example.features.screens.product.ProductViewModel
import com.example.features.screens.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val featuresModule = module {

    single(named("screens")) { ScreensImpl() as Screens }

    viewModel { AuthViewModel() }
    viewModel { RegistrationViewModel() }
    viewModel { SetMealPlanViewModel() }
    viewModel { InputPersonalViewModel() }
    viewModel { MainViewModel() }
    viewModel { ProductViewModel() }
    viewModel { BasketViewModel() }
}