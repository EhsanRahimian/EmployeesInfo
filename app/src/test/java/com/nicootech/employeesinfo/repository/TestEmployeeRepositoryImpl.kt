package com.nicootech.employeesinfo.repository

import com.nicootech.employeesinfo.BaseTest
import com.nicootech.employeesinfo.FakeEmployees
import com.nicootech.employeesinfo.network.EmployeesService
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestEmployeeRepositoryImpl : BaseTest(){
    @RelaxedMockK
    lateinit var employeesService: EmployeesService

    private lateinit var employeeRepositoryImpl :EmployeeRepositoryImpl

    @BeforeEach
    override fun setUp() {
        super.setUp()
        employeeRepositoryImpl = EmployeeRepositoryImpl(employeesService)
    }

    @Test
    fun `getEmployees should return Employees`() = runBlocking {
        val employees = FakeEmployees.list()

        coEvery { employeesService.getEmployees().employees }
            .answers { employees }

        val result = employeeRepositoryImpl.getEmployees()
        assert(result == employees)
    }
}