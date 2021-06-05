package com.man.domain.model

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.man.domain.R


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
data class CoinDataDomain(
    val id: String,
    val name: String,
    val fullName: String,
    val price: String,
    val changeHours: String,
    val conditionCrypto: ConditionCrypto
) {
    object CoinDataDomainComparator : DiffUtil.ItemCallback<CoinDataDomain>() {
        override fun areItemsTheSame(oldItem: CoinDataDomain, newItem: CoinDataDomain) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CoinDataDomain, newItem: CoinDataDomain) =
            oldItem == newItem
    }


}