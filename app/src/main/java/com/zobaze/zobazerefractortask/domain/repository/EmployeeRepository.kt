package com.zobaze.zobazerefractortask.domain.repository

import com.zobaze.zobazerefractortask.domain.entity.Employee

interface EmployeeRepository {
    suspend fun getAllEmployees(): List<Employee> /* todo - enclose in result */
}