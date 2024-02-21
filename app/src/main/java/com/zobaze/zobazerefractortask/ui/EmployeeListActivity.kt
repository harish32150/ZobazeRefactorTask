package com.zobaze.zobazerefractortask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.zobaze.zobazerefractortask.databinding.ActivityEmployeeListBinding
import com.zobaze.zobazerefractortask.domain.KResult
import com.zobaze.zobazerefractortask.domain.entity.Employee
import com.zobaze.zobazerefractortask.domain.handle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EmployeeListActivity : AppCompatActivity() {
    private val binding by lazy { ActivityEmployeeListBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[EmployeeListViewModel::class.java] }
    private val adapter by lazy { EmployeeListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rv.adapter = adapter
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.employeeListResultFlow.collectLatest(::handleEmployeeListResult)
        }
    }

    private fun handleEmployeeListResult(result: KResult<List<Employee>>) {
        result.handle(
            onSuccess = adapter::submitList,
            onLoading = { binding.containerProgress.isVisible = it },
            onError = {
                binding.apply {
                    containerError.isVisible = true
                    textError.text = it.message ?: it.toString()
                }
            }
        )
    }
}