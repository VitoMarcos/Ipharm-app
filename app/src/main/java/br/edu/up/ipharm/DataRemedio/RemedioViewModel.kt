package br.edu.up.ipharm.DataRemedio

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.livedata.ktx.R
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemedioViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Remedio>>
    private val repository: RemedioRepository

    init {
        val remedioDao = RemedioDatabase.getDatabase(application).remedioDao()
        repository = RemedioRepository(remedioDao)
        readAllData = repository.readAllData
    }

    fun addRemedio(remedio: Remedio){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRemedio(remedio)
        }
    }

    fun updateRemedio(remedio: Remedio){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRemedio(remedio)
        }
    }

    fun deleteRemedio(remedio: Remedio){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRemedio(remedio)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}