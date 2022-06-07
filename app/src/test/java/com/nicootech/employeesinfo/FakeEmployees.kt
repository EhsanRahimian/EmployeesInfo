package com.nicootech.employeesinfo

import com.nicootech.employeesinfo.BaseFaker.Companion.Fake.fake
import com.nicootech.employeesinfo.model.EmployeeEntity
import com.nicootech.employeesinfo.model.EmployeeType

object FakeEmployees {

    private fun basic() = EmployeeEntity(
        fake.idNumber().valid(),
        fake.name().fullName(),
        fake.phoneNumber().phoneNumber(),
        fake.internet().emailAddress(),
        fake.lorem().word(),
        fake.internet().url(),
        fake.internet().url(),
        fake.lorem().word(),
        EmployeeType.CONTRACTOR
    )

    fun list() = BaseFaker.list { basic() }
}