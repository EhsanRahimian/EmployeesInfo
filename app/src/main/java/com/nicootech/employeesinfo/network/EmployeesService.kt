package com.nicootech.employeesinfo.network

import com.nicootech.employeesinfo.model.EmployeesEntity
import com.nicootech.employeesinfo.util.Constant.Companion.EMPLOYEES_ENDPOINT
import retrofit2.http.GET

interface EmployeesService {
    @GET(EMPLOYEES_ENDPOINT)
    suspend fun getEmployees(): EmployeesEntity
}