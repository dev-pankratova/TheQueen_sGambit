package com.example.features.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.base.BaseFragment
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentMainBinding
import com.example.common.entities.MealItem
import com.example.common.storage.inStorageSelectedMeal
import com.example.common.storage.registeredUser
import com.example.features.screens.meals.categories.CategoriesMealsAdapter
import com.example.features.screens.meals.recommended.OnMealItemClickListener
import com.example.features.screens.meals.recommended.RecommendedMealAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {

    override val viewModel: MainViewModel by viewModel()

    private lateinit var binding: FragmentMainBinding

    private val onMealItemClickListener = object : OnMealItemClickListener {
        override fun onClick(mealItem: MealItem) {
            viewModel.onOpenMealDetails(mealItem)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarMain.title = registeredUser?.address
        binding.recomRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = RecommendedMealAdapter(onMealItemClickListener).apply {
                setMeals(viewModel.provideRecommendedMeals())
            }
        }
        binding.categoriesRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = CategoriesMealsAdapter().apply {
                setMeals(viewModel.provideCategories())
            }
        }
        binding.basketBtn.setOnClickListener {
            if (inStorageSelectedMeal != null) {
                viewModel.onOpenBasketScreen(inStorageSelectedMeal!!)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        binding.basketBtn.apply {
            if (inStorageSelectedMeal != null) {
                isVisible = true
                text = inStorageSelectedMeal?.price
            } else {
                isVisible = false
                text = ""
            }
        }
    }
}