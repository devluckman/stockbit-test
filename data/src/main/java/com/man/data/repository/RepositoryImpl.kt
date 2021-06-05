package com.man.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.man.data.datasource.TopTierDataSource
import com.man.data.remote.service.ApiService
import com.man.domain.model.CoinDataDomain
import com.man.domain.repository.Repository
import kotlinx.coroutines.flow.Flow


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
class RepositoryImpl(
    private val apiService: ApiService
) : Repository {

    override suspend fun getTopTierList(): Flow<PagingData<CoinDataDomain>> = Pager(
        config = PagingConfig(pageSize = 10, enablePlaceholders = false),
        pagingSourceFactory = { TopTierDataSource(apiService) }
    ).flow

}