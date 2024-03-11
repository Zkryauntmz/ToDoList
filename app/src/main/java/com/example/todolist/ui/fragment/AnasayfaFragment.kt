package com.example.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.data.entity.ToDoList
import com.example.todolist.databinding.FragmentAnasayfaBinding
import com.example.todolist.ui.adapter.Adapter
import com.example.todolist.ui.viewmodel.YapilacakKayitViewmoModel
import com.example.todolist.utils.gecis
import dagger.hilt.android.AndroidEntryPoint
import com.example.todolist.ui.viewmodel.AnasayfaViewModel as AnasayfaViewModel

@AndroidEntryPoint

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
   private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        binding = FragmentAnasayfaBinding.inflate(inflater, container,false)


        viewModel.notlarListesi.observe(viewLifecycleOwner){
            val notlarAdapter = Adapter(requireContext(),it,viewModel)
            binding.notlarRv.adapter= notlarAdapter

        }

        binding.notlarRv.layoutManager= LinearLayoutManager(requireContext())


        binding.fabEkle.setOnClickListener {
          //  Navigation.findNavController(it).navigate(R.id.kayitGecis)
            Navigation.gecis(it,R.id.kayitGecis)
        }



        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{

            override fun onQueryTextChange(newText: String): Boolean {
                //Harf Girdikçe Calısır
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                //Klavyedeki arama butonu ıle calsır


                viewModel.ara(query)
                return true
            }



        })




        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempView :AnasayfaViewModel by viewModels()
        viewModel =tempView
    }

    override fun onResume() {
        super.onResume()
        viewModel.notYukle()
    }

}