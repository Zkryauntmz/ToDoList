package com.example.todolist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.data.entity.ToDoList

@Dao
interface NotlarDao {
    @Query("SELECT * FROM todolist")
    suspend fun notlariYukle():List<ToDoList>

    @Insert
    suspend fun kaydet(not:ToDoList)
    @Update
    suspend fun guncelleme(not:ToDoList)
    @Delete
    suspend fun sil(not:ToDoList)


    @Query("SELECT * FROM todolist WHERE not_ad like '%'||:aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi:String) :List<ToDoList>
}