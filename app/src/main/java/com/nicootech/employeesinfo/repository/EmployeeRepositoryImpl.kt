package com.nicootech.employeesinfo.repository

import com.nicootech.employeesinfo.model.EmployeeEntity
import com.nicootech.employeesinfo.network.EmployeesService

class EmployeeRepositoryImpl (
    private val api: EmployeesService
)
{
    suspend fun getEmployees(): List<EmployeeEntity> =
        api.getEmployees().employees
}