package com.havelisolutions.mvipractice.generics

//Response is generic for error handling loading handling and data handling
//Sealed classed can not be instaniated only child class instantiate it and only this file class can extent it
//it is safe type because we know what are the results in it only success error or loading can be called
sealed class SafeApiResponse<T>(
    val data: T? = null,
    val message: String? = null,
    val statusCode: Int? = null
) {
    class Success<T>(data: T? = null, statusCode: Int?) :
        SafeApiResponse<T>(
            data = data,
            statusCode = statusCode
        )

    class Loading<T>(data: T? = null) :
        SafeApiResponse<T>(data)

    class Error<T>(
        data: T? = null,
        message: String?,
        statusCode: Int?
    ) :
        SafeApiResponse<T>(data, message, statusCode)

}