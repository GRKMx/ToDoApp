package com.gorkemersizer.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.gorkemersizer.todoapp.R
import com.gorkemersizer.todoapp.databinding.CardTasarimBinding
import com.gorkemersizer.todoapp.entity.Yapilacaklar
import com.gorkemersizer.todoapp.ui.fragment.AnaSayfaFragmentDirections
import com.gorkemersizer.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.gorkemersizer.todoapp.util.gecisYap

class YapilacaklarAdapter(
    var mContext: Context,
    var yapilacaklarListesi:List<Yapilacaklar>,
    var viewModel: AnasayfaFragmentViewModel
): RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(binding: CardTasarimBinding):RecyclerView.ViewHolder(binding.root) {
        var binding:CardTasarimBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi.get(position)
        val t = holder.binding
        t.yapilacakNesnesi = yapilacak

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it, "$yapilacak silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }

        t.satirCard.setOnClickListener {
            val gecis = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToDetayFragment(yapilacak)
            Navigation.gecisYap(it, gecis)
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}