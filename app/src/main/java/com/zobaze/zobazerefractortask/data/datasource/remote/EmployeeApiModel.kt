package com.zobaze.zobazerefractortask.data.datasource.remote

import com.google.gson.annotations.SerializedName
import com.zobaze.zobazerefractortask.domain.entity.Employee

data class EmployeeApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("employee_name") val name: String,
    @SerializedName("employee_salary") val salary: Long,
    @SerializedName("employee_age") val age: Int,
    @SerializedName("profile_image") val profileImage: String?
) {
    fun toEmployee(): Employee = Employee(id, name, salary, age, profileImage)
}