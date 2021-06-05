package com.man.data.remote.response

import com.man.domain.model.CoinDataDomain
import com.man.domain.model.ConditionCrypto
import com.squareup.moshi.Json

data class TopTierResponse(

    @Json(name = "RateLimit")
    val rateLimit: RateLimit,

    @Json(name = "Type")
    val type: Int,

    @Json(name = "Message")
    val message: String,

    @Json(name = "MetaData")
    val metaData: MetaData,

    @Json(name = "HasWarning")
    val hasWarning: Boolean,

    @Json(name = "Data")
    val data: List<CoinData?>,

    @Json(name = "SponsoredData")
    val sponsoredData: List<SponsoredDataItem>
) {
    companion object {

        fun List<CoinData?>.toDomain(): List<CoinDataDomain> {
            val data = mutableListOf<CoinDataDomain>()
            forEach {
                data.add(transform(it))
            }
            return data
        }

        private fun transform(response: CoinData?): CoinDataDomain {
            return CoinDataDomain(
                id = response?.coinInfo?.id ?: "",
                name = response?.coinInfo?.name ?: "",
                fullName = response?.coinInfo?.fullName ?: "",
                price = response?.rAW?.usd?.price ?: 0.toString(),
                changeHours = "${response?.display?.uSD?.changehour ?: 0.0} (${response?.display?.uSD?.changepcthour ?: 0.0})",
                conditionCrypto = getCondition(response?.display?.uSD)
            )
        }

        private fun getCondition(usd: USD?): ConditionCrypto {
            return when {
                usd?.changepcthour?.contains("-") == true -> ConditionCrypto.DOWN
                else -> ConditionCrypto.UP
            }

        }

    }
}