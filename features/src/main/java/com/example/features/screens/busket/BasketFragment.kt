package com.example.features.screens.busket

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.common.base.BaseFragment
import com.example.common.entities.MealItem
import com.example.common.storage.inStorageSelectedMeal
import com.example.common.storage.registeredUser
import com.example.feature_auth.R
import com.example.feature_auth.databinding.FragmentBasketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BasketFragment : BaseFragment(R.layout.fragment_basket) {

    override val viewModel: BasketViewModel by viewModel()
    private lateinit var binding: FragmentBasketBinding

    private val selectedMeal by lazy { arguments?.getParcelable("meal") as MealItem? }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showSelectedMeal()
        setCardInfoClick()
        setBasketClickListener()
    }

    private fun setCardInfoClick() {
        binding.cardInfoBtn.setOnClickListener {
            binding.cardEt.visibility = View.VISIBLE
        }
    }

    private fun setBasketClickListener() {
        binding.checkoutBtn.setOnClickListener {
            AlertDialog.Builder(requireContext()).apply {
                setTitle("Ваш заказ оформлен!\nОжидайте курьера в течение часа.")
                setPositiveButton(android.R.string.ok) { p0, p1 ->
                    inStorageSelectedMeal = null
                    viewModel.returnToMainScreen()
                }
            }.show()
        }
    }

    private fun showSelectedMeal() {
        binding.apply {
            Glide.with(image).load(selectedMeal?.image)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .into(image)
            name.text = selectedMeal?.title
            price.text = selectedMeal?.price
            totalPrice.text = "${(150 + selectedMeal!!.priceAmount)} ₸"
            deliveryAddressInput.text = registeredUser?.address
        }
    }

    companion object {

        fun getInstance(meal: MealItem): BasketFragment {
            return BasketFragment().apply {
                arguments = bundleOf("meal" to meal)
            }
        }
    }
}