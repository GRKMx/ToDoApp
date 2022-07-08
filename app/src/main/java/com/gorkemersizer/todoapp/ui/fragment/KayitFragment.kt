package com.gorkemersizer.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gorkemersizer.todoapp.R
import com.gorkemersizer.todoapp.databinding.FragmentKayitBinding
import com.gorkemersizer.todoapp.ui.viewmodel.KayitFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false)
        binding.kayitFragment = this
        binding.kayitToolbarBaslik = "To DO Kayıt"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(yapilacak_is: String) {
        viewModel.kayit(yapilacak_is)
    }
}