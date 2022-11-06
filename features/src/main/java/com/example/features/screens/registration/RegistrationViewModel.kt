package com.example.features.screens.registration

import com.example.common.base.BaseViewModel
import com.example.common.entities.UserInfo
import com.example.common.storage.registeredUser

class RegistrationViewModel : BaseViewModel() {

    fun register(phone: String, password: String) {
        registeredUser = UserInfo(
            phone = phone,
            password = password
        )
        router.navigateTo(screens.setMealPlanScreen())
    }

    fun navigateToLogin() {
        router.backTo(screens.authScreen())
    }
}