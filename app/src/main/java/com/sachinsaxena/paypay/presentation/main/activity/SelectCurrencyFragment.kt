package com.sachinsaxena.paypay.presentation.main.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sachinsaxena.paypay.presentation.base.BaseBindingDialogFragment
import com.sachinsaxena.paypay.presentation.base.action.ActionPerformer
import com.sachinsaxena.paypay.presentation.base.action.OnCurrencySelect
import com.sachinsaxena.common.domain.CurrencyDetails
import com.sachinsaxena.paypay.databinding.FragmentSelectCurrencyBinding
import com.sachinsaxena.paypay.presentation.main.adapter.CurrencyListAdaptor
import com.sachinsaxena.paypay.presentation.main.viewmodel.CurrencyConvertorViewModel

class SelectCurrencyFragment :
    BaseBindingDialogFragment<CurrencyConvertorViewModel, FragmentSelectCurrencyBinding>() {

    companion object {
        const val TAG = "SelectCurrencyFragment"
        fun newInstance() = SelectCurrencyFragment()
    }

    private val currencyDetailsAdapter: CurrencyListAdaptor by lazy {
        CurrencyListAdaptor(object : ActionPerformer {
            override fun performAction(action: Any) {
                when (action) {
                    is OnCurrencySelect -> {
                        viewModel.currencyDetailsFrom.value = CurrencyDetails(action.code, action.name)
                        dismiss()
                    }
                }
            }
        })
    }

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSelectCurrencyBinding =
        FragmentSelectCurrencyBinding.inflate(layoutInflater, container, false)

    override fun providePageName(): String = TAG

    override fun provideViewModel(): CurrencyConvertorViewModel =
        ViewModelProvider(requireActivity())[CurrencyConvertorViewModel::class.java]

    override fun setupView(view: View, savedInstanceState: Bundle?) {
        mBinding?.rvCurrencies?.adapter = currencyDetailsAdapter
    }

    override fun getTheme(): Int {
        return android.R.style.Theme_Light_NoTitleBar_Fullscreen
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.currencyDetailsListLiveData.observe(viewLifecycleOwner) {
            updateRecyclerView(it)
        }
    }

    private fun updateRecyclerView(currencies: List<CurrencyDetails>?) {
        if (currencies == null) return
        currencyDetailsAdapter.appendList(currencies)
    }
}