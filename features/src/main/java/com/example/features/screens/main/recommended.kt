package com.example.features.screens.main

import com.example.feature_auth.R
import com.example.common.entities.MealItem

internal val recommendedMeals = listOf(
    MealItem(
        id = 1,
        title = "Молочный пудинг",
        weight = "250 мл.",
        price = "800 ₸",
        priceAmount = 800,
        description = "Коровье молоко, сахар, крахмал, ванилин.",
        allergen = "laktoza",
        image = R.drawable.puding,
    ),
    MealItem(
        id = 2,
        title = "Классическая Гёдза",
        weight = "150 г.",
        price = "500 ₸",
        priceAmount = 500,
        description = "кукурузная крупа, сахар-песок,масло подсолнечное рафинированное дезодорированное,соль поваренная пищевая, вода питьевая, ароматизатор идентичный натуральному ванилин.",
        allergen = "sugar",
        image = R.drawable.meal_gedze,
    ),
    MealItem(
        id = 3,
        title = "Белковый салат с тунцом",
        weight = "350 г.",
        price = "500 ₸",
        priceAmount = 500,
        description = " Не-тунец, черри, тофу, соль, масло, бобы.",
        allergen = "soya",
        image = R.drawable.tunec,
    ),
    MealItem(
        id = 4,
        title = "Авокадо",
        weight = "350 г.",
        price = "500 ₸",
        priceAmount = 500,
        description = "Цельный авокадо 1 шт.",
        allergen = "no",
        image = R.drawable.avocado,
    ),
    MealItem(
        id = 5,
        title = "Вареники (заморозка)",
        weight = "500 г.",
        price = "800 ₸",
        priceAmount = 800,
        description = "мука первого сорта, картофель, лук, перец, масло, соль.",
        allergen = "gluten",
        image = R.drawable.vareniki,
    ),
    MealItem(
        id = 6,
        title = "Миндальное молоко",
        weight = "1 л.",
        price = "2500 ₸",
        priceAmount = 2500,
        description = "Миндаль, вода, соль.",
        allergen = "almond",
        image = R.drawable.milk,
    )
)

internal val categories = listOf(
    MealItem(
        id = 1,
        title = "Готовая еда",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.gotovaya_eda,
    ),
    MealItem(
        id = 2,
        title = "Приготовьте сами",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.avocado,
    ),
    MealItem(
        id = 3,
        title = "Заморозка",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.vareniki,
    ),
    MealItem(
        id = 4,
        title = "Выпечка без глютена",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.vypechka_bez_glutena,
    ),
    MealItem(
        id = 5,
        title = "Альтернативное молоко",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.milk,
    ),
    MealItem(
        id = 6,
        title = "Соевое мясо",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.soevoe_myaso,
    ),
    MealItem(
        id = 7,
        title = "Овощи и зелень",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.ovochi_green,
    ),
    MealItem(
        id = 8,
        title = "Фрукты и ягоды",
        weight = "",
        price = "",
        priceAmount = 0,
        description = "",
        allergen = "",
        image = R.drawable.fruits,
    ),
)