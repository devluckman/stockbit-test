package com.man.stockbittest.presentation.home.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import com.man.core.base.BaseFragment
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.databinding.FragmentPortfolioBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PortfolioFragment : BaseFragment<GlobalViewModel, FragmentPortfolioBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPortfolioBinding
        get() = FragmentPortfolioBinding::inflate

    override fun initProcess() {

    }

    override fun onActionListener() = with(binding) {

    }

}