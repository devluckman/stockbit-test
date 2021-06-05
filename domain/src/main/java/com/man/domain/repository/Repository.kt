package com.man.domain.repository

import androidx.paging.PagingData
import com.man.domain.model.CoinDataDomain
import kotlinx.coroutines.flow.Flow

/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
interface Repository {

    suspend fun getTopTierList() : Flow<PagingData<CoinDataDomain>>

}