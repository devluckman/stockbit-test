package com.man.domain.usecase

import androidx.paging.PagingData
import com.man.domain.model.CoinDataDomain
import com.man.domain.repository.Repository
import kotlinx.coroutines.flow.Flow


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
class UseCaseImpl(
    private val repository: Repository
) : UseCase {

    override suspend fun getTopTierList(): Flow<PagingData<CoinDataDomain>> =
        repository.getTopTierList()


}