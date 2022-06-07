package com.nicootech.employeesinfo.di

import com.nicootech.employeesinfo.network.EmployeesService
import com.nicootech.employeesinfo.repository.EmployeeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        api : EmployeesService
    ) : EmployeeRepositoryImpl {

        return EmployeeRepositoryImpl(api)
    }
}