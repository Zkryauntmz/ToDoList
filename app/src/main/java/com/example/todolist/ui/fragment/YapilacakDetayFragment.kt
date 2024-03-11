package com.example.todolist.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todolist.R
import com.example.todolist.databinding.FragmentYapilacakDetayBinding
import com.example.todolist.ui.viewmodel.YapilacakDetayViewModel
import com.example.todolist.ui.viewmodel.YapilacakKayitViewmoModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
@AndroidEntryPoint


class YapilacakDetayFragment : Fragment() {
    private lateinit var binding: FragmentYapilacakDetayBinding
    private  lateinit var viewModel :YapilacakDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentYapilacakDetayBinding.inflate(inflater,container,false)

        //gelen bilgiyi burda almamız lazım

        val bundle:YapilacakDetayFragmentArgs by navArgs()
        val gelenNot = bundle.not

        binding.editTextAd.setText(gelenNot.not_ad)
        binding.editTextAcKla.setText(gelenNot.aciklama)


        binding.buttonGuncelle.setOnClickListener {
            val not_ad = binding.editTextAd.text.toString()
            val  aciklama = binding.editTextAcKla.text.toString()
            viewModel.guncelle(gelenNot.not_id,not_ad, aciklama )
            }



        return binding.root
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YapilacakDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}