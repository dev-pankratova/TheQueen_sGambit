package com.example.features.screens.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.example.common.base.BaseFragment
import com.example.common.entities.MealItem
import com.example.common.storage.inStorageSelectedMeal
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentProductBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment(R.layout.fragment_product) {

    override val viewModel: ProductViewModel by viewModel()

    private lateinit var binding: FragmentProductBinding

    private val selectedMeal by lazy { arguments?.getParcelable("meal") as MealItem? }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProductDetails()
        setBtnClickListener()
    }

    private fun showProductDetails() {
        binding.apply {
            Glide.with(productImg).load(selectedMeal?.image).into(productImg)
            productName.text = selectedMeal?.title
            weightTxt.text = selectedMeal?.weight
            compoundTextXt.text = selectedMeal?.description
            addBtn.text = "+ ${selectedMeal?.price}"
            allergenInputTxt.text = selectedMeal?.allergen
        }
    }

    private fun setBtnClickListener() {
        binding.addBtn.setOnClickListener {
            inStorageSelectedMeal = selectedMeal
        }
    }

    companion object {

        fun getInstance(meal: MealItem): ProductFragment {
            return ProductFragment().apply {
                arguments = bundleOf("meal" to meal)
            }
        }
    }
}