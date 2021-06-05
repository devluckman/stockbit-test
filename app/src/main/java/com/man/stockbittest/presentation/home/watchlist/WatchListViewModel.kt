package com.man.stockbittest.presentation.home.watchlist

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.man.core.base.BaseViewModel
import com.man.domain.model.CoinDataDomain
import com.man.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow

class WatchListViewModel(
    private val useCase: UseCase
) : BaseViewModel() {

    private lateinit var _coinDataFlow: Flow<PagingData<CoinDataDomain>>
    val coinDataFlow: Flow<PagingData<CoinDataDomain>>
        get() = _coinDataFlow

    init {
        getAllTopTierCrypto()
    }

    private fun getAllTopTierCrypto() = launchPagingAsync({
        useCase.getTopTierList().cachedIn(viewModelScope)
    }, {
        _coinDataFlow = it
    })

}