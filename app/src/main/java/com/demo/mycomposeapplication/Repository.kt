package com.demo.mycomposeapplication

import javax.inject.Inject

class Repository @Inject constructor(val apiService: ApiService): DataSource() {

    suspend fun getData()= getData {
        apiService.getData()
    }
}