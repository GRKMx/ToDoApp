package com.gorkemersizer.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.gorkemersizer.todoapp.R
import com.gorkemersizer.todoapp.databinding.FragmentDetayBinding
import com.gorkemersizer.todoapp.databinding.FragmentKayitBinding
import com.gorkemersizer.todoapp.ui.viewmodel.DetayFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container, false)
        binding.detayFragment = this
        binding.detayToolbarBaslik = "To Do Detay"

        val bundle: DetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak
        binding.yapilacakNesnesi = gelenYapilacak

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelleTikla(yapilacak_id: Int, yapilacak_is: String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)
    }
}