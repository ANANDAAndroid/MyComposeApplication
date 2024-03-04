package com.demo.mycomposeapplication

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @GET("/v3/b/65e580091f5677401f3815b0")
    suspend fun getData():QuotesDataModel.Response

}