package com.example.todolist.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.data.entity.ToDoList

@Database(entities = [ToDoList::class], version = 1)
abstract class Veritabani :RoomDatabase() {
    abstract fun getNotlarDao():NotlarDao
}