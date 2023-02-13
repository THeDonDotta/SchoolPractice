package com.example.practiceschool.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceschool.data.SchoolDetails
import com.example.practiceschool.model.SchoolApi
import kotlinx.coroutines.launch

class SchoolViewModel: ViewModel() {

    var schoolResponse: List<SchoolDetails> by mutableStateOf(listOf())

    fun getSchools() {
        viewModelScope.launch {
            val apiService = SchoolApi.getInstance()

            val schoolList = apiService.getSchools()
            schoolResponse = schoolList
        }

    }
}