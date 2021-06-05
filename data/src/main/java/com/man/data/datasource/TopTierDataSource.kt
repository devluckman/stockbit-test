package com.man.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.man.data.remote.response.TopTierResponse.Companion.toDomain
import com.man.data.remote.service.ApiService
import com.man.domain.model.CoinDataDomain


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
class TopTierDataSource(
    private val apiService: ApiService
) : PagingSource<Int, CoinDataDomain>() {

    override fun getRefreshKey(state: PagingState<Int, CoinDataDomain>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CoinDataDomain> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiService.getTopTierList(page = currentLoadingPageKey)
            val pagedResponse = response.body()
            val data = pagedResponse?.data?.toDomain() ?: emptyList()

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1
            return LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }


}