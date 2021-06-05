package com.man.stockbittest.presentation.home.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.man.core.base.BaseFragment
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<GlobalViewModel, FragmentSearchBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun initProcess() {

    }

    override fun onActionListener() = with(binding) {

    }

}