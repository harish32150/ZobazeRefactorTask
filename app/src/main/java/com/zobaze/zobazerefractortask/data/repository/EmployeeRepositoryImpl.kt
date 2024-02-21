package com.zobaze.zobazerefractortask.data.repository

import com.zobaze.zobazerefractortask.domain.entity.Employee
import com.zobaze.zobazerefractortask.domain.repository.EmployeeRepository

class EmployeeRepositoryImpl: EmployeeRepository {
    override suspend fun getAllEmployees(): List<Employee> {
        TODO("Not yet implemented")
    }
}