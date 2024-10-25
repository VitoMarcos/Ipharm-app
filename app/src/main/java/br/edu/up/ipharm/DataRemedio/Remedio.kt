package br.edu.up.ipharm.DataRemedio

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "tabela_remedio")
data class Remedio(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nome: String,
    val foto: Int?,
    val msg : String
): Parcelable
