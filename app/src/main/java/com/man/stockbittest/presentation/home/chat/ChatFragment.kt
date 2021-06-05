package com.man.stockbittest.presentation.home.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import com.man.core.base.BaseFragment
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.databinding.FragmentChatBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChatFragment : BaseFragment<GlobalViewModel, FragmentChatBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentChatBinding
        get() = FragmentChatBinding::inflate

    override fun initProcess() {

    }

    override fun onActionListener() = with(binding) {

    }

}