package com.example.features.screens.auth

import com.example.common.base.BaseViewModel

class AuthViewModel : BaseViewModel() {

    fun navigateToRegistration() {
        router.navigateTo(screens.registrationScreen())
    }

    fun navigateToMainScreen() {
        router.navigateTo(screens.mainScreen())
    }
}