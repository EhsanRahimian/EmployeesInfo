package com.nicootech.employeesinfo.viewmodel

import androidx.lifecycle.Observer
import com.nicootech.employeesinfo.BaseTest
import com.nicootech.employeesinfo.FakeEmployees
import com.nicootech.employeesinfo.model.EmployeesEntity
import com.nicootech.employeesinfo.repository.EmployeeRepository
import com.nicootech.employeesinfo.ui.EmployeesViewModel
import com.nicootech.employeesinfo.util.DataState
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verifySequence
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestEmployeesViewModel : BaseTest(){

    @RelaxedMockK
    lateinit var employeeRepository: EmployeeRepository

    @RelaxedMockK
    lateinit var stateObserver: Observer<DataState<EmployeesEntity>>

    private lateinit var employeesViewModel: EmployeesViewModel


    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @BeforeEach
    override fun setUp() {
        super.setUp()
        Dispatchers.setMain(mainThreadSurrogate)
        employeesViewModel = EmployeesViewModel(employeeRepository)
    }


    @AfterEach
    override fun tearDown() {
        Dispatchers.resetMain() // resets the main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `getEmployees must show Success state`() = runBlocking {

        employeesViewModel.dataState.observeForever(stateObserver)
        val employees = FakeEmployees.list()

        coEvery { employeeRepository.getEmployees() }
            .answers { employees }

        launch(Dispatchers.Main) {
            employeesViewModel.getEmployees()
        }

        verifySequence {
            stateObserver.onChanged(DataState.Loading)
            stateObserver.onChanged(any<DataState.Success<EmployeesEntity>>())
        }
    }
}