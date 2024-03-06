package com.demo.mycomposeapplication.api

import com.demo.mycomposeapplication.model.QuotesDataModel
import retrofit2.http.GET

interface ApiService {
    @GET("/v3/b/65e580091f5677401f3815b0")
    suspend fun getData(): QuotesDataModel.Response

}