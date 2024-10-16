package br.edu.up.ipharm.DataRemedio

import androidx.lifecycle.LiveData

class RemedioRepository(private val remedioDao: RemedioDao) {

    val readAllData: LiveData<List<Remedio>> = remedioDao.readAllData()


    suspend fun addRemedio(remedio: Remedio){
        remedioDao.addRemedio(remedio)
    }

    suspend fun updateRemedio(remedio: Remedio){
        remedioDao.updateRemedio(remedio)
    }

    suspend fun deleteRemedio(remedio: Remedio){
        remedioDao.deleteRemedio(remedio)
    }

    suspend fun deleteAll(){
        remedioDao.deleteAll()
    }

}