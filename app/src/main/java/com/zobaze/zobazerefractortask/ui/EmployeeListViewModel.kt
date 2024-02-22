package com.zobaze.zobazerefractortask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zobaze.zobazerefractortask.domain.KResult
import com.zobaze.zobazerefractortask.domain.entity.Employee
import com.zobaze.zobazerefractortask.domain.usecase.EmployeeListInSequenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class EmployeeListViewModel @Inject constructor(private val employeeListUseCase: EmployeeListInSequenceUseCase) :
    ViewModel() {

    /* employee list result flow */
    val employeeListResultFlow = flow<KResult<List<Employee>>> {
        emit(KResult.Loading)
        emit(employeeListUseCase())
    }.stateIn(viewModelScope, started = SharingStarted.Lazily, initialValue = KResult.Loading)
}