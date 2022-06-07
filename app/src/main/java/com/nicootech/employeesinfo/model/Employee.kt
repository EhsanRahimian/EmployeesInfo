package com.nicootech.employeesinfo.model

data class Employee (
    //domain model
    val uuid: String,
    val name: String,
    val phone: String,
    val email: String,
    val bio: String,
    val photol: String,
    val photos: String,
    val team: String,
    val type: EmployeeType
    )

enum class EmployeeType {
    FULL_TIME,
    PART_TIME,
    CONTRACTOR
}