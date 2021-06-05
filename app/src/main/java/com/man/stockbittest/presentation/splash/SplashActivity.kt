package com.man.stockbittest.presentation.splash

import android.view.LayoutInflater
import com.man.core.base.BaseActivity
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.databinding.ActivitySplashBinding
import com.man.stockbittest.presentation.login.LoginActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<GlobalViewModel, ActivitySplashBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater) -> ActivitySplashBinding
        get() = ActivitySplashBinding::inflate

    override fun initProcess() {
        launch {
            delay(3000)
            launchActivity(LoginActivity::class.java)
            finish()
        }
    }

    override fun onActionListener() = with(bind) {

    }
}