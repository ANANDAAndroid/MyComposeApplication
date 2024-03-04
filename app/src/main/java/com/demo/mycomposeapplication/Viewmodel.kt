package com.demo.mycomposeapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(private val repository: Repository): ViewModel() {


     private val _response:MutableStateFlow<Status<QuotesDataModel.Response>> = MutableStateFlow(Status.Loading)
    val response: StateFlow<Status<QuotesDataModel.Response>>  get() = _response
    fun getData() =viewModelScope.launch {
        _response.emit(repository.getData())
    }
}