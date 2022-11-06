package com.example.features.screens.personal_info

import com.example.common.base.BaseViewModel
import com.example.common.storage.registeredUser

class InputPersonalViewModel : BaseViewModel() {

    fun keepPersonalInfo(name: String, age: String, address: String) {
        registeredUser?.name = name
        registeredUser?.age = age
        registeredUser?.address = address
        router.navigateTo(screens.mainScreen())
    }
}