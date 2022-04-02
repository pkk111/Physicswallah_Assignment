package com.example.physicswallah.ui.professorList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.physicswallah.APIClient
import com.example.physicswallah.Data.ProfessorsData.ProfessorModel
import kotlinx.coroutines.*

class ProfessorListViewModel : ViewModel() {

    private val _professorsList = MutableLiveData<List<ProfessorModel>>()
    val professorsList : LiveData<List<ProfessorModel>> = _professorsList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> = _errorMessage

    var job: Job? = null

    val loading = MutableLiveData<Boolean>()

    fun getAllProfessors() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = APIClient.getInstance().getAllMovies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    _professorsList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        _errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}