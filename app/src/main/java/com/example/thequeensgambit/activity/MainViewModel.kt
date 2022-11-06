package com.example.thequeensgambit.activity

import com.example.common.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    fun launchAuthScreen() {
        router.newRootScreen(screens.authScreen())
    }
}