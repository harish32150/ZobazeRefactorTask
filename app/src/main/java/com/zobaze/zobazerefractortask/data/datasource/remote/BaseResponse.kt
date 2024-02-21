package com.zobaze.zobazerefractortask.data.datasource.remote

import com.google.gson.annotations.SerializedName

/**
 * Represents common/base response for employee service
 *
 * @param T serialised class representing list/object
 */
data class BaseResponse<T>(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: T,
    @SerializedName("message") val message: String
)