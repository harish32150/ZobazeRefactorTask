package com.zobaze.zobazerefractortask.data.datasource.remote

data class EmployeeApiModel(
    /*"id":1,
    "employee_name":"Tiger Nixon",
"employee_salary":320800,
"employee_age":61,
"profile_image":""*/
    val id: String,
    val name: String,
    val salary: Long,
    val age: Int,
    val profileImage: String?
)