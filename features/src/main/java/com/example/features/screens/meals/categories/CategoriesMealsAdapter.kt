package com.example.features.screens.meals.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.entities.MealItem
import com.example.feature_auth.databinding.ItemMealBinding
import com.example.feature_auth.databinding.ItemMealCategoryBinding
import com.example.features.screens.meals.recommended.OnMealItemClickListener

class CategoriesMealsAdapter() :
    RecyclerView.Adapter<RecommendedMealViewHolder>() {

    val meals = mutableListOf<MealItem>()

    fun setMeals(meals: List<MealItem>) {
        this.meals.clear()
        this.meals.addAll(meals)
        notifyDataSetChanged()
    }

    override fun getItemCount() = meals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedMealViewHolder {
        return RecommendedMealViewHolder(
            ItemMealCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecommendedMealViewHolder, position: Int) {
        holder.onBind(meals[position])
    }
}

class RecommendedMealViewHolder(
    private val binding: ItemMealCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(meal: MealItem) {
        binding.title.text = meal.title
        binding.apply {
            Glide.with(binding.imgItemId)
                .load(meal.image)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .into(binding.imgItemId)
        }
    }
}