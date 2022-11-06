package com.example.common.entities

data class UserInfo(
    var name: String = "",
    var password: String = "",
    var phone: String = "",
    var age: String = "",
    var country: String = "",
    var address: String = "",
    val allergens: MutableList<String> = mutableListOf(),
)