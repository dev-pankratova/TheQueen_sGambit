package com.example.features.screens.personal_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentInputPersonalInfoBinding
import org.koin.android.ext.android.inject

class InputPersonalInfoFragment : BaseFragment(R.layout.fragment_input_personal_info) {

    override val viewModel: InputPersonalViewModel by inject()
    private lateinit var binding: FragmentInputPersonalInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputPersonalInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNextClickListener()
    }

    private fun setNextClickListener() {
        binding.nextInfoBtn.setOnClickListener {
            viewModel.keepPersonalInfo(
                name = binding.textInputEditTxtName.text.toString(),
                age = binding.textInputEditTxtAge.text.toString(),
                address = binding.textInputEditTxtAddress.text.toString()
            )
        }
    }

}