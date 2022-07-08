package com.gorkemersizer.todoapp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
//import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.gorkemersizer.todoapp.R
import com.gorkemersizer.todoapp.databinding.FragmentAnaSayfaBinding
import com.gorkemersizer.todoapp.ui.adapter.YapilacaklarAdapter
import com.gorkemersizer.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.gorkemersizer.todoapp.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class AnaSayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =DataBindingUtil.inflate(inflater, R.layout.fragment_ana_sayfa, container, false)
        binding.anasayfaFragment = this
        binding.anaSayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnaSayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner) {
            val adapter =YapilacaklarAdapter(requireContext(), it, viewModel)
            binding.yapilacaklarAdapter = adapter
        }

        return binding.root
    }

    fun fabTikla(v:View){
        Navigation.gecisYap(v,R.id.action_anaSayfaFragment_to_kayitFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnasayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        viewModel.ara(p0)
        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        viewModel.ara(p0)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }

}