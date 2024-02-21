package com.zobaze.zobazerefractortask.data.repository

import com.zobaze.zobazerefractortask.data.datasource.remote.EmployeeService
import com.zobaze.zobazerefractortask.domain.entity.Employee
import com.zobaze.zobazerefractortask.domain.repository.EmployeeRepository
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val apiService: EmployeeService) :
    EmployeeRepository {

    override suspend fun getAllEmployees(): List<Employee> {
        TODO("Not yet implemented")
    }
}