package com.nicootech.employeesinfo.repository

import com.nicootech.employeesinfo.model.EmployeeEntity

interface MainRepository {
    suspend fun getEmployees(): List<EmployeeEntity>
}