package com.nicootech.employeesinfo.model

import com.google.gson.annotations.SerializedName
import com.nicootech.employeesinfo.util.EntityMapper

data class EmployeeEntity (
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("full_name")
    val name: String,
    @SerializedName("phone_number")
    val phone: String,
    @SerializedName("email_address")
    val email: String,
    @SerializedName("biography")
    val bio: String,
    @SerializedName("photo_url_large")
    val photol: String,
    @SerializedName("photo_url_small")
    val photos: String,
    @SerializedName("team")
    val team: String,
    @SerializedName("employee_type")
    val type: EmployeeType
) :EntityMapper<Employee>{
    override fun mapFromEntity(): Employee {
        return Employee(
            name = name,
            uuid = uuid,
            phone = phone,
            email = email,
            bio = bio,
            photos = photos,
            photol = photol,
            team = team,
            type = type
        )
    }

}

