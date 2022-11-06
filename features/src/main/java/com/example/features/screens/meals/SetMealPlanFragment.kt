package com.example.features.screens.meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.common.base.BaseFragment
import com.example.common.storage.registeredUser
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentSetMealPlanBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SetMealPlanFragment : BaseFragment(R.layout.fragment_set_meal_plan) {

    override val viewModel: SetMealPlanViewModel by viewModel()

    private lateinit var binding: FragmentSetMealPlanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSetMealPlanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAllergenList()
        saveAllergenClick()
        setNextClickListener()
    }

    private fun setAllergenList() {
        val countries: Array<out String> = resources.getStringArray(R.array.allergen_array)
        ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, countries).also { adapter ->
            binding.autoCompleteTxtView.setAdapter(adapter)
        }

    }

    private fun saveAllergenClick() {
        binding.addAllergBtn.setOnClickListener {
            registeredUser?.allergens?.add(binding.autoCompleteTxtView.text.toString())
        }
    }

    private fun setNextClickListener() {
        binding.nextMealPlanBtn.setOnClickListener {
            viewModel.navigateToSecondPlan() }
    }

}