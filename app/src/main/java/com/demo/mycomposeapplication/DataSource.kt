package com.demo.mycomposeapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class DataSource {
    suspend fun<Api> getData(data:suspend () -> Api):Status<Api>{
        return withContext(Dispatchers.IO){
           try {
               Status.Success(data.invoke())
           }catch (throwable:Throwable){

               when(throwable){
                   is HttpException ->{
                       Status.Failure(false, throwable.code())
                   }
                   else->{
                       Status.Failure(true,null)
                   }
               }

           }
            }
        }
}