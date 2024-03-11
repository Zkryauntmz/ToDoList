package com.example.todolist.data.datasource

import android.util.Log
import com.example.todolist.data.entity.ToDoList
import com.example.todolist.room.NotlarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotlarDataSource(var ndao:NotlarDao) {

    //kaydet işlemi
    suspend fun kaydet(not_ad:String,aciklama :String ){
        val yeniNot = ToDoList(0,not_ad, aciklama)
        ndao.kaydet(yeniNot)

    }


        //guncelleme
    suspend fun guncelle (not_id:Int,not_ad:String,aciklama:String){
            val guncellenenNot = ToDoList(not_id,not_ad, aciklama)
            ndao.guncelleme(guncellenenNot)
    }


    suspend fun sil (not_id:Int){
        val silinenNot = ToDoList(not_id,"","")
        ndao.sil(silinenNot)
    }

    suspend fun notlariYukle():List<ToDoList> =
        withContext(Dispatchers.IO){

        return@withContext ndao.notlariYukle()
    }

  suspend  fun ara(aramaKelimesi:String) : List<ToDoList> =
      withContext(Dispatchers.IO){

      return@withContext ndao.ara(aramaKelimesi)
  }


}