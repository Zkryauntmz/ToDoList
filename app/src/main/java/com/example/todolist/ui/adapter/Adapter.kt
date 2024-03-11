package com.example.todolist.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.entity.ToDoList
import com.example.todolist.databinding.CardTasarimBinding
import com.example.todolist.databinding.FragmentAnasayfaBinding
import com.example.todolist.ui.fragment.AnasayfaFragmentDirections
import com.example.todolist.ui.viewmodel.AnasayfaViewModel
import com.example.todolist.utils.gecis
import com.google.android.material.snackbar.Snackbar

class Adapter(var mContext:Context ,
              var notlarListesi : List<ToDoList>,
              var viewModel: AnasayfaViewModel):
    RecyclerView.Adapter<Adapter.CardTasarim>() {

    inner class CardTasarim(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarim {
      val  binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent,false)
        return CardTasarim(binding)
    }

    override fun onBindViewHolder(holder: CardTasarim, position: Int) {
val not = notlarListesi.get(position)
        val t = holder.tasarim
        t.textViewNotAd.text =not.not_ad
        t.textViewAciklama.text=not.aciklama

        t.cardVeiwSatir.setOnClickListener{
            //Card a tıklayınca guncelleme sayfasına yonlendırme
            val gecis= AnasayfaFragmentDirections.detayGecis(not = not)

            //Navigation.findNavController(it).navigate(gecis)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${not.not_ad } Silinmesini ister misiniz ?  " , Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(not.not_id)

                }.show()
        }

    }

    override fun getItemCount(): Int {
      return notlarListesi.size
    }

}