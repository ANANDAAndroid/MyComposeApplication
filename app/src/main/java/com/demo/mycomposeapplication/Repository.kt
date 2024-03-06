package com.demo.mycomposeapplication

import com.demo.mycomposeapplication.api.ApiService
import com.demo.mycomposeapplication.api.DataSource
import javax.inject.Inject

class Repository @Inject constructor(val apiService: ApiService): DataSource() {

    suspend fun getData()= getData {
        apiService.getData()
    }
}