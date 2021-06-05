package com.man.stockbittest.presentation.home.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import com.man.core.base.BaseFragment
import com.man.stockbittest.databinding.FragmentWatchlistBinding
import com.man.stockbittest.presentation.home.adapter.CoinAdapter
import com.man.stockbittest.presentation.home.adapter.PagingLoadStateAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchListFragment : BaseFragment<WatchListViewModel, FragmentWatchlistBinding>() {

    override val viewModel: WatchListViewModel by viewModel()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWatchlistBinding
        get() = FragmentWatchlistBinding::inflate

    override fun initProcess() {
        initRv(viewModel, CoinAdapter())
    }

    private fun initRv(vm: WatchListViewModel, adapter: CoinAdapter) = with(binding) {
        with(adapter) {
            swipeRefresh.setOnRefreshListener { refresh() }
            rvCrypto.adapter = withLoadStateHeaderAndFooter(
                header = PagingLoadStateAdapter(this),
                footer = PagingLoadStateAdapter(this)
            )
            with(vm) {
                launchOnLifecycleScope {
                    coinDataFlow.collect { submitData(it) }
                }
                launchOnLifecycleScope {
                    loadStateFlow.collect {
                        swipeRefresh.isRefreshing = it.refresh is LoadState.Loading
                    }
                }
            }
        }
    }

    override fun onActionListener() = with(binding) {

    }
}