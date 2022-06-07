package com.nicootech.employeesinfo.repository

import com.nicootech.employeesinfo.BaseTest
import com.nicootech.employeesinfo.FakeEmployees
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestEmployeeRepository : BaseTest() {

    @MockK
    lateinit var employeeRepositoryImpl: EmployeeRepositoryImpl

    private lateinit var employeeRepository: EmployeeRepository

    @BeforeEach
    override fun setUp() {
        super.setUp()
        employeeRepository = EmployeeRepository(employeeRepositoryImpl)
    }
    @Test
    fun `getEmployees must returns Employees`() = runBlocking {
        val employees = FakeEmployees.list()

        coEvery { employeeRepositoryImpl.getEmployees() }
            .answers { employees}

        val result = employeeRepository.getEmployees()
        assert(result == employees)
    }
}