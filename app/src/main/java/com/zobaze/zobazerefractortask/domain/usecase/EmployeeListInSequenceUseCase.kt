package com.zobaze.zobazerefractortask.domain.usecase

import com.zobaze.zobazerefractortask.domain.KResult
import com.zobaze.zobazerefractortask.domain.entity.Employee
import com.zobaze.zobazerefractortask.domain.map
import com.zobaze.zobazerefractortask.domain.repository.EmployeeRepository
import javax.inject.Inject

class EmployeeListInSequenceUseCase @Inject constructor(private val repository: EmployeeRepository) {
    suspend operator fun invoke(): KResult<List<Employee>> =  repository.getAllEmployees()
        .map { _list ->
            _list.filter { it.id % 3 == 0 } + _list.filter { it.id % 7 == 0 } + _list.filter { it.id % 4 ==0 }
        }
}