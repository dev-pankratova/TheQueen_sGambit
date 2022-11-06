package com.example.features.screens.busket

import com.example.common.base.BaseViewModel

class BasketViewModel : BaseViewModel() {

    fun returnToMainScreen() {
        router.backTo(screens.mainScreen())
    }
}