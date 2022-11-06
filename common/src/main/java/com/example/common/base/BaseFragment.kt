package com.example.common.base

import androidx.fragment.app.Fragment

abstract class BaseFragment(private val layoutId: Int, private val screen: String? = null) : Fragment(layoutId) {

    abstract val viewModel: BaseViewModel

    open fun onBackPressed() {
        viewModel.close()
    }

}