package com.sachinsaxena.paypay.presentation.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sachinsaxena.common.InjectUtils
import com.sachinsaxena.common.domain.CurrencyDetails
import com.sachinsaxena.common.extensions.gone
import com.sachinsaxena.common.extensions.toast
import com.sachinsaxena.common.extensions.viewModelProvider
import com.sachinsaxena.common.extensions.visible
import com.sachinsaxena.paypay.databinding.ActivityCurrencyConvertorBinding
import com.sachinsaxena.paypay.di.component.DaggerPayPayAppComponent
import com.sachinsaxena.paypay.di.module.AppModule
import com.sachinsaxena.paypay.presentation.base.BaseBindingActivity
import com.sachinsaxena.paypay.presentation.base.action.ActionPerformer
import com.sachinsaxena.paypay.presentation.base.action.OnCurrencySelect
import com.sachinsaxena.paypay.presentation.main.adapter.CurrencyListAdaptor
import com.sachinsaxena.paypay.presentation.main.viewmodel.CurrencyConvertorViewModel
import com.sachinsaxena.paypay.utils.CurrencyValidator
import javax.inject.Inject

class CurrencyConvertorActivity :
    BaseBindingActivity<CurrencyConvertorViewModel, ActivityCurrencyConvertorBinding>() {

    companion object {
        private const val TAG = "CurrencyConvertorActivity"

        fun getStartIntent(context: Context): Intent =
            Intent(context, CurrencyConvertorActivity::class.java)
    }

    private val currencyAdapter: CurrencyListAdaptor by lazy {
        CurrencyListAdaptor(object : ActionPerformer {
            override fun performAction(action: Any) {
                when (action) {
                    is OnCurrencySelect -> {
                        val amountEntered = binding.etAmount.text?.trim()
                        if (!CurrencyValidator.isValidAmountEntered(amountEntered)) {
                            toast("Please enter correct amount")
                            return
                        }
                        val currencyFromCode = viewModel.currencyDetailsFrom.value?.code
                        if (!CurrencyValidator.isValidCurrencyCode(currencyFromCode)) {
                            toast("Please select correct currency")
                            return
                        }
                        if (!CurrencyValidator.isValidConversion(currencyFromCode!!, action.code)) {
                            toast("Please don't convert into same currency, the value will not change!!")
                            return
                        }
                        binding.btConvert.text = viewModel.getConvertedRate(
                            binding.etAmount.text.toString().toDouble(),
                            currencyFromCode,
                            action.code
                        ).toString()
                    }
                }
            }
        })
    }

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerPayPayAppComponent
            .builder()
            .appModule(AppModule(application))
            .commonComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun provideViewBinding(): ActivityCurrencyConvertorBinding =
        ActivityCurrencyConvertorBinding.inflate(layoutInflater)

    override fun providePageName(): String = TAG

    override fun provideViewModel(): CurrencyConvertorViewModel =
        viewModelProvider(viewModelProvider)

    override fun setupView(savedInstanceState: Bundle?) {
        binding.rvCurrencies.adapter = currencyAdapter
        binding.tvSelectCurrency.setOnClickListener {
            SelectCurrencyFragment.newInstance()
                .show(supportFragmentManager, SelectCurrencyFragment.TAG)
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.loadingLiveData.observe(this) { isVisible ->
            if (isVisible) {
                binding.loadingProgressbar.visible()
            } else {
                binding.loadingProgressbar.gone()
            }
        }

        viewModel.currencyDetailsListLiveData.observe(this) {
            updateRecyclerView(it)
        }

        viewModel.currencyDetailsFrom.observe(this) {
            binding.tvSelectCurrency.text = it.name
        }
    }

    private fun updateRecyclerView(currencies: List<CurrencyDetails>?) {
        if (currencies == null) return
        currencyAdapter.appendList(currencies)
        hideLoading()
    }

    private fun showLoading(message: String) {
        binding.apply {
            tvLoadingMessage.text = message
            tvLoadingMessage.visible()
            loadingProgressbar.visible()
        }
    }

    private fun hideLoading() {
        binding.apply {
            tvLoadingMessage.gone()
            loadingProgressbar.gone()
        }
    }
}