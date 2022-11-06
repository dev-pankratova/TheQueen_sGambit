package com.example.features.screens.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentAuthBinding
import org.koin.android.ext.android.inject

class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    override val viewModel: AuthViewModel by inject()
    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTextClickListener()
        setLoginClickListener()
    }

    private fun setTextClickListener() {
        binding.nextTxt.setOnClickListener { viewModel.navigateToRegistration() }
    }

    private fun setLoginClickListener() {
        binding.loginBtn.setOnClickListener { viewModel.navigateToMainScreen() }
    }
}