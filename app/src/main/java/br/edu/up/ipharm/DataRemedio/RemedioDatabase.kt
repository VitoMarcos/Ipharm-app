package br.edu.up.ipharm.DataRemedio

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Remedio::class], version = 1, exportSchema = false)
abstract class RemedioDatabase : RoomDatabase() {

    abstract fun remedioDao(): RemedioDao

    companion object{

        @Volatile
        private var INSTANCE: RemedioDatabase? = null

        fun getDatabase(context: Context): RemedioDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RemedioDatabase::class.java,
                    "tabela_remedio"
                ).build()

                INSTANCE = instance
                return instance

            }



        }


    }


}