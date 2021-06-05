package com.man.core.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewbinding.ViewBinding
import com.man.core.extentions.observeData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity(),
    CoroutineScope {

    private val parentJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = parentJob + Dispatchers.Main
    abstract val viewModel: VM

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val bind: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Handling Force Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        onViewReady()
    }

    private fun onViewReady() {
        initProcess()
        onActionListener()
        onSubscription()
    }

    private fun onSubscription() = with(viewModel) {
        observeData(errorMessage) {
            showMessage(it)
        }
    }

    // initialize process
    protected abstract fun initProcess()

    // initialize listener
    protected abstract fun onActionListener()

    open fun showMessage(message: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    protected infix fun View.goTo(cls: Class<*>) {
        setOnClickListener { launchActivity(cls) }
    }

    protected fun launchActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}