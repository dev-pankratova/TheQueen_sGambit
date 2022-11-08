package com.example.features.screens.meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.common.storage.registeredUser
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentSetMealPlan2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SetMealPlanFragment2 : BaseFragment(R.layout.fragment_set_meal_plan_2) {

    override val viewModel: SetMealPlanViewModel by viewModel()

    private lateinit var binding: FragmentSetMealPlan2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSetMealPlan2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNextClickListener()
    }

    private fun setNextClickListener() {
        binding.next2Txt.setOnClickListener {
            addAllergen()
            viewModel.navigateToInputPersonalInfo() }
    }

    private fun addAllergen() {
        binding.apply {
            if (check1.isChecked) {
                registeredUser?.allergens?.add("laktoza")
            }
            if (check2.isChecked) {
                registeredUser?.allergens?.add("gluten")
            }
            if (check3.isChecked) {
                registeredUser?.allergens?.add("meat")
            }
            if (check4.isChecked) {
                registeredUser?.allergens?.add("fish")
            }
        }
    }
}