package com.zobaze.zobazerefractortask.domain.repository

import com.zobaze.zobazerefractortask.domain.KResult
import com.zobaze.zobazerefractortask.domain.entity.Employee

interface EmployeeRepository {

    /** Provides all [Employee] as [KResult] */
    suspend fun getAllEmployees(): KResult<List<Employee>>
}