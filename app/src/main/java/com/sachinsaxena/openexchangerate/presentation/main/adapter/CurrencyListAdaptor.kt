package com.sachinsaxena.openexchangerate.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sachinsaxena.openexchangerate.presentation.base.BaseViewHolder
import com.sachinsaxena.openexchangerate.presentation.base.action.ActionPerformer
import com.sachinsaxena.openexchangerate.presentation.base.action.OnCurrencySelect
import com.sachinsaxena.common.domain.CurrencyDetails
import com.sachinsaxena.openexchangerate.databinding.LayoutCurrencyBinding

/**
Created by Sachin Saxena on 29/09/22.
 */
class CurrencyListAdaptor(private val listener: ActionPerformer) :
    RecyclerView.Adapter<BaseViewHolder<CurrencyDetails>>() {

    private val currencyDetailsList = ArrayList<CurrencyDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CurrencyDetails> {

        return CurrencyViewHolder(
            LayoutCurrencyBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            actionPerformer = listener
        }
    }

    override fun getItemCount(): Int = currencyDetailsList.size

    fun updateItemAt(beer: CurrencyDetails, position: Int) {
        if (position > currencyDetailsList.size) return
        currencyDetailsList[position] = beer
        notifyItemChanged(position)
    }

    fun appendList(beerList: List<CurrencyDetails>) {
        this.currencyDetailsList.clear()
        val startPosition = this.currencyDetailsList.size
        this.currencyDetailsList.addAll(beerList)
        notifyItemRangeInserted(startPosition, beerList.size)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<CurrencyDetails>, position: Int) {
        holder.bind(currencyDetailsList[position])
    }

    inner class CurrencyViewHolder(private val binding: LayoutCurrencyBinding) :
        BaseViewHolder<CurrencyDetails>(binding.root) {

        override fun bind(data: CurrencyDetails) {

            binding.tvCurrency.text = data.name
            binding.tvCode.text = data.code

            binding.root.setOnClickListener {
                actionPerformer?.performAction(
                    OnCurrencySelect(
                        code = data.code,
                        name = data.name
                    )
                )
            }
        }
    }
}