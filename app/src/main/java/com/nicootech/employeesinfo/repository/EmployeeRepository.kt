package com.nicootech.employeesinfo.repository

import com.nicootech.employeesinfo.model.EmployeeEntity
import javax.inject.Inject


class EmployeeRepository @Inject constructor(
    private val employeeRepositoryImpl: EmployeeRepositoryImpl):MainRepository
{
    override suspend fun getEmployees(): List<EmployeeEntity> =
        employeeRepositoryImpl.getEmployees()
}