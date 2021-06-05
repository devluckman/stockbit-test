package com.man.core.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.man.core.extentions.observeData


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    abstract val viewModel: VM

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        Toast.makeText(requireContext(), message, duration).show()
    }

    protected infix fun View.goTo(cls: Class<*>) {
        setOnClickListener { startActivity(cls) }
    }

    private fun startActivity(cls: Class<*>) = with(requireActivity()) {
        startActivity(Intent(this, cls))
    }

    fun launchOnLifecycleScope(execute: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            execute()
        }
    }

    // Clears the binding and removes the observer when the Fragment's views get destroyed.
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun clearViewBinding() {
        _binding = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}