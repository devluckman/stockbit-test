package com.man.stockbittest.presentation.home

import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.man.core.base.BaseActivity
import com.man.core.base.GlobalViewModel
import com.man.stockbittest.R
import com.man.stockbittest.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<GlobalViewModel, ActivityMainBinding>() {

    override val viewModel: GlobalViewModel by viewModel()
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun initProcess() {
        initNavigation()
    }

    private fun initNavigation() = with(bind) {
        val navView: BottomNavigationView = navView
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    override fun onActionListener() = with(bind) {

    }


}