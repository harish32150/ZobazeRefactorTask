package com.zobaze.zobazerefractortask.data.repository

import com.zobaze.zobazerefractortask.data.datasource.remote.EmployeeService
import com.zobaze.zobazerefractortask.domain.KResult
import com.zobaze.zobazerefractortask.domain.entity.Employee
import com.zobaze.zobazerefractortask.domain.map
import com.zobaze.zobazerefractortask.domain.repository.EmployeeRepository
import com.zobaze.zobazerefractortask.domain.runCatchingResult
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val apiService: EmployeeService) :
    EmployeeRepository {

    override suspend fun getAllEmployees(): KResult<List<Employee>> =
        runCatchingResult { apiService.getAll() }
            .map { response -> response.data.map { it.toEmployee() } }
}