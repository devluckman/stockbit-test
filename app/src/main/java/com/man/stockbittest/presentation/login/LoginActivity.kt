package com.man.stockbittest.presentation.login

import android.view.LayoutInflater
import com.man.core.base.BaseActivity
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.databinding.ActivityLoginBinding
import com.man.stockbittest.presentation.home.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<GlobalViewModel, ActivityLoginBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater) -> ActivityLoginBinding
        get() = ActivityLoginBinding::inflate

    override fun initProcess() {

    }

    override fun onActionListener() = with(bind) {

        btnFacebook goTo MainActivity::class.java

        btnGoogle goTo MainActivity::class.java

        btnLogin goTo MainActivity::class.java

    }
}