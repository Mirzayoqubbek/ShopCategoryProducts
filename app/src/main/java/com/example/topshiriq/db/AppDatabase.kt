package com.example.topshiriq.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.model.PostModel

@Database(entities = [CategoryModel::class, PostModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPostDao(): PostDao
    abstract fun getCategoryDao(): CategoryDao
    companion object{
        var INSTANSE: AppDatabase? = null

        fun ininDatabase(context: Context){
            if (INSTANSE == null){
                synchronized(AppDatabase::class){
                    INSTANSE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "topshirq_db").build()
                }

            }
        }

        fun getDatabase(): AppDatabase{
            return INSTANSE!!
        }
    }
}