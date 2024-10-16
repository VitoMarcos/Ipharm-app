package br.edu.up.ipharm.DataRemedio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface RemedioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRemedio(remedio: Remedio)

    @Update
    suspend fun updateRemedio(remedio: Remedio)

    @Delete
    suspend fun deleteRemedio(remedio: Remedio)

    @Query("DELETE FROM tabela_remedio")
    suspend fun deleteAll()

    @Query("SELECT * FROM tabela_remedio ORDER BY nome ASC")
    fun readAllData(): LiveData<List<Remedio>>



}