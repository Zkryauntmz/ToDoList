package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacakDetayViewModel @Inject constructor(var nrepo : NotlarRepository) : ViewModel() {

     fun guncelle(not_id:Int,not_ad:String,aciklama:String)
     {
         CoroutineScope(Dispatchers.Main).launch {
             nrepo.guncelle(not_id, not_ad, aciklama)
         }
     }

}