package com.man.stockbittest.module

import com.man.core.base.GlobalViewModel
import com.man.stockbittest.presentation.home.watchlist.WatchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */

val viewModel = module {

    viewModel { GlobalViewModel() }

    viewModel { WatchListViewModel(get()) }
}