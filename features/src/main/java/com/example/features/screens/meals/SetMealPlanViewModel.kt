package com.example.features.screens.meals

import com.example.common.base.BaseViewModel

class SetMealPlanViewModel : BaseViewModel() {

    fun navigateToSecondPlan() {
        router.navigateTo(screens.setMealPlanScreen2())
    }

    fun navigateToInputPersonalInfo() {
        router.navigateTo(screens.inputPersonalInfoScreen())
    }
}