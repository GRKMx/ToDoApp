package com.gorkemersizer.todoapp.repo

import androidx.lifecycle.MutableLiveData
import com.gorkemersizer.todoapp.entity.Yapilacaklar
import com.gorkemersizer.todoapp.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var ydao: YapilacaklarDao) {
    var yapilacaklarListesi: MutableLiveData<List<Yapilacaklar>>

    init {
        yapilacaklarListesi = MutableLiveData()
    }

    fun yapilacaklariGetir():MutableLiveData<List<Yapilacaklar>> {
        return yapilacaklarListesi
    }

    fun yapilacakKayit(yapilacak_is: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniYapilacakIs = Yapilacaklar(0, yapilacak_is)
            ydao.yapilacakEkle(yeniYapilacakIs)
        }
    }

    fun yapilacakGuncelle(yapilacak_id: Int, yapilacak_is: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenYapilacakIs = Yapilacaklar(yapilacak_id, yapilacak_is)
            ydao.yapilacakGuncelle(guncellenenYapilacakIs)
        }
    }

    fun yapilacakAra(aramaKelimesi: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = ydao.yapilacakArama(aramaKelimesi)
        }
    }

    fun yapilacakSil(kisi_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Yapilacaklar(kisi_id,"")
            ydao.yapilacakSil(silinenKisi)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = ydao.tumYapilacaklar()
        }
    }
}