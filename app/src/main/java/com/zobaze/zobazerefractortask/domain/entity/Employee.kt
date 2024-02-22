package com.zobaze.zobazerefractortask.domain.entity

data class Employee(
    val id: Int,
    val name: String,
    val salary: Long,
    val age: Int,
    val profileImage: String?
)