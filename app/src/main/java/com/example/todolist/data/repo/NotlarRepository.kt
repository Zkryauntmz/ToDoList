package com.example.todolist.data.repo

import com.example.todolist.data.datasource.NotlarDataSource
import com.example.todolist.data.entity.ToDoList

class NotlarRepository(var nds: NotlarDataSource) {

  //  var nds = NotlarDataSource()

    suspend fun kaydet(not_ad:String,aciklama :String) = nds.kaydet(not_ad,aciklama)
    suspend fun guncelle(not_id:Int,not_ad:String,aciklama:String) =
        nds.guncelle(not_id,not_ad,aciklama)
    suspend fun sil (not_id:Int) = nds.sil(not_id)
    suspend fun notlariYukle():List<ToDoList> = nds.notlariYukle()
    suspend  fun ara(aramaKelimesi:String) : List<ToDoList> = nds.ara(aramaKelimesi)
}