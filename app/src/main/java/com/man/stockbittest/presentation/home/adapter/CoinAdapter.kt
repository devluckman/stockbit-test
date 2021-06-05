package com.man.stockbittest.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.man.domain.model.CoinDataDomain
import com.man.domain.model.CoinDataDomain.CoinDataDomainComparator
import com.man.domain.model.ConditionCrypto
import com.man.stockbittest.R
import com.man.stockbittest.databinding.ItemCardCryptoBinding


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
class CoinAdapter :
    PagingDataAdapter<CoinDataDomain, CoinAdapter.CoinViewHolder>(CoinDataDomainComparator) {


    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder =
        CoinViewHolder(
            ItemCardCryptoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    inner class CoinViewHolder(private val binding: ItemCardCryptoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CoinDataDomain) = with(binding) {
            tvNameCrypto.text = item.name
            tvFullNameCrypto.text = item.fullName
            tvPriceCrypto.text = item.price
            tvPercentCrypto.text = item.changeHours

            tvPercentCrypto.setTextColor(
                ContextCompat.getColor(
                    itemView.context,
                    getColor(item.conditionCrypto)
                )
            )
        }

        private fun getColor(conditionCrypto: ConditionCrypto): Int =
            if (conditionCrypto == ConditionCrypto.UP) {
                R.color.green
            } else {
                R.color.red
            }
    }

}