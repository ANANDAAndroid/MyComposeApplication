package com.demo.mycomposeapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.mycomposeapplication.api.Status
import com.demo.mycomposeapplication.model.QuotesDataModel
import com.demo.mycomposeapplication.model.Response
import com.demo.mycomposeapplication.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _responseInsertData:MutableStateFlow<Status<Boolean>> = MutableStateFlow(Status.Loading)
    val responseInsertData:StateFlow<Status<Boolean>> get() = _responseInsertData
    fun insertData(todo:Todo) =viewModelScope.launch{
        repository.insertToDo(todo)
    }
}