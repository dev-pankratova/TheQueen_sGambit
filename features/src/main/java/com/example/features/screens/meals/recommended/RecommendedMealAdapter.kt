package com.example.features.screens.meals.recommended

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.entities.MealItem
import com.example.feature_auth.databinding.ItemMealBinding

class RecommendedMealAdapter(private val clickListener: OnMealItemClickListener) :
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
            ItemMealBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecommendedMealViewHolder, position: Int) {
        holder.onBind(meals[position], clickListener)
    }
}

class RecommendedMealViewHolder(
    private val binding: ItemMealBinding
) : ViewHolder(binding.root) {

    fun onBind(meal: MealItem, listener: OnMealItemClickListener) {
        binding.root.setOnClickListener {
            listener.onClick(meal)
        }
        binding.apply {
            Glide.with(binding.imgItemId)
                .load(meal.image)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .into(binding.imgItemId)
        }
    }
}