package com.example.todolist.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todolist.R
import com.example.todolist.databinding.FragmentYapilacaKayitBinding
import com.example.todolist.ui.viewmodel.AnasayfaViewModel
import com.example.todolist.ui.viewmodel.YapilacakKayitViewmoModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class YapilacaKayitFragment : Fragment() {
    private lateinit var binding: FragmentYapilacaKayitBinding
private lateinit var  viewModel: YapilacakKayitViewmoModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentYapilacaKayitBinding.inflate(inflater,container,false)

        binding.buttonKayit.setOnClickListener {
            val notAdi = binding.editYapilacakAd.text.toString()
            val aciklama = binding.editYapilacakAck.text.toString()
            viewModel.kaydet(notAdi,aciklama)

        }




        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YapilacakKayitViewmoModel by viewModels()
        viewModel = tempViewModel
    }

}

