package com.example.features.screens.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentRegistrationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : BaseFragment(R.layout.fragment_registration) {

    override val viewModel: RegistrationViewModel by viewModel()

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTextClickListener()
        setBtnClickListener()
    }

    private fun setTextClickListener() {
        binding.yesAccountTxt.setOnClickListener {
            viewModel.navigateToLogin()
        }
    }

    private fun setBtnClickListener() {
        binding.registrationBtn.setOnClickListener {
            viewModel.register(
                phone = binding.textInputEditTxtPhoneNew.text.toString(),
                password = binding.textInpetEditTxtPassNew.text.toString()
            )
        }
    }
}