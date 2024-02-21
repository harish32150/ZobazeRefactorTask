package com.zobaze.zobazerefractortask.data.datasource.remote

import retrofit2.http.GET

interface EmployeeService {
    @GET("v1/employees")
    suspend fun getAll(): BaseResponse<List<EmployeeApiModel>>
}