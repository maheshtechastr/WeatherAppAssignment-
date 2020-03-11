package com.mpg.assignment1.data.models

sealed class ResponseResult

data class ResponseSuccess<T>(val data: T) : ResponseResult()

data class ResponseError<T>(val errorData: T) : ResponseResult()