package com.nicootech.employeesinfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.nicootech.employeesinfo.databinding.ActivityEmployeesBinding
import com.nicootech.employeesinfo.model.EmployeesEntity
import com.nicootech.employeesinfo.ui.adapter.EmployeeListAdapter
import com.nicootech.employeesinfo.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeesActivity : AppCompatActivity() {


    private lateinit var binding: ActivityEmployeesBinding
    private val employeesViewModel: EmployeesViewModel by viewModels()
    private val employeesAdapter = EmployeeListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.contentLayout.swipeContainer.setOnRefreshListener {
            employeesViewModel.getEmployees()
            binding.loadingLayout.progressBar.visibility = View.GONE
        }

        binding.contentLayout.recyclerView.apply {
            visibility = View.VISIBLE
            adapter = employeesAdapter
        }

        employeesViewModel.getEmployees()

        employeesViewModel.dataState.observe(this) { expression(it) }
    }

    private fun expression(mood: DataState<EmployeesEntity>) = with( binding) {

        contentLayout.recyclerView.isVisible = mood is DataState.Success
        loadingLayout.progressBar.isVisible = mood is DataState.Loading
        errorLayout.errorLayout.isVisible = mood is DataState.Error
        emptyLayout.root.isVisible = mood is DataState.Empty

        if(mood !is DataState.Loading)
            contentLayout.swipeContainer.isRefreshing = false

        if(mood is DataState.Success){
            employeesAdapter.submitList(mood.employees)
        }

    }
}