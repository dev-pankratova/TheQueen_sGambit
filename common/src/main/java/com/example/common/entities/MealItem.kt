package com.example.common.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MealItem(
    val id: Int,
    val title: String,
    val weight: String,
    val price: String,
    val priceAmount: Int,
    val description: String,
    val allergen: String,
    val image: Int
) : Parcelable