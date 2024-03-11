package com.example.todolist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.entity.ToDoList
import com.example.todolist.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor(var nrepo : NotlarRepository): ViewModel() {


    var notlarListesi = MutableLiveData<List<ToDoList>>()

    init {
        notYukle()
    }
     fun sil (not_id:Int)
     {

         CoroutineScope(Dispatchers.Main).launch {
             nrepo.sil(not_id)
            notYukle()
         }

     }
    fun notYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value= nrepo.notlariYukle()
        }
    }
    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value= nrepo.ara(aramaKelimesi)
        }
    }
}