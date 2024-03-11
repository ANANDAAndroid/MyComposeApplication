package com.demo.mycomposeapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.mycomposeapplication.api.Status
import com.demo.mycomposeapplication.model.QuotesDataModel
import com.demo.mycomposeapplication.model.TodoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(private val repository: Repository): ViewModel() {


    private val _response:MutableStateFlow<Status<QuotesDataModel.Response>> = MutableStateFlow(
         Status.Loading)
    val response: StateFlow<Status<QuotesDataModel.Response>>  get() = _response
    fun getData() =viewModelScope.launch {
        _response.emit(repository.getData())
    }

    private val _responseInsertData:MutableStateFlow<Status<Long>> = MutableStateFlow(Status.Success(0))
    val responseInsertData:StateFlow<Status<Long>> get() = _responseInsertData

    fun insertData(todoModel:TodoModel) =viewModelScope.launch{
        _responseInsertData.value=Status.Loading
        _responseInsertData.value=repository.insertToDo(todoModel)
    }

    private val _responseGetData:MutableStateFlow<Status<List<TodoModel>>> = MutableStateFlow(Status.Success(emptyList()))
    val responseGetData:StateFlow<Status<List<TodoModel>>> get() = _responseGetData

    fun getTodoData() =viewModelScope.launch{
        _responseGetData.value=Status.Loading
        delay(500)
        _responseGetData.value=repository.getToDo()

    }
}