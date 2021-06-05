package com.man.stockbittest.presentation.home.stream

import android.view.LayoutInflater
import android.view.ViewGroup
import com.man.core.base.BaseFragment
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.databinding.FragmentStreamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StreamFragment : BaseFragment<GlobalViewModel, FragmentStreamBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStreamBinding
        get() = FragmentStreamBinding::inflate

    override fun initProcess() {

    }

    override fun onActionListener() = with(binding) {

    }

}