package com.nicootech.employeesinfo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicootech.employeesinfo.model.EmployeesEntity
import com.nicootech.employeesinfo.repository.EmployeeRepository
import com.nicootech.employeesinfo.util.DataState
import com.nicootech.employeesinfo.util.mapFromEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class EmployeesViewModel
@Inject
constructor(
    private val employeeRepository: EmployeeRepository
): ViewModel()
{
    val dataState: LiveData<DataState<EmployeesEntity>>
        get() = _dataState
    private val _dataState: MutableLiveData<DataState<EmployeesEntity>> = MutableLiveData()

    fun getEmployees() {
        _dataState.value = DataState.Loading

        viewModelScope.launch {
            runCatching {

                try {
                    val employees = employeeRepository.getEmployees().mapFromEntities()
                    _dataState.value =
                        if(employees.isNotEmpty()) DataState.Success(employees)
                        else DataState.Empty
                } catch (e: Exception) {
                    _dataState.value = DataState.Error(e)
                }
            }
        }
    }

}