package com.nicootech.employeesinfo.util

import com.nicootech.employeesinfo.model.Employee
import java.lang.Exception

sealed class DataState<out R> {

    data class Success<out T>(val employees: List<Employee>): DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Empty: DataState<Nothing>()
    object Loading : DataState<Nothing>()

}