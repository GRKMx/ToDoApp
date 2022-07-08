package com.gorkemersizer.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gorkemersizer.todoapp.entity.Yapilacaklar

@Database(entities = [Yapilacaklar::class], version = 2)
abstract class Veritabani: RoomDatabase() {
    abstract fun getYapilacaklarDao(): YapilacaklarDao
}