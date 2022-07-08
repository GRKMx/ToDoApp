package com.gorkemersizer.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.gorkemersizer.todoapp.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor(var yrepo: YapilacaklarDaoRepository): ViewModel(){
    fun kayit(yapilacak_is: String) {
        yrepo.yapilacakKayit(yapilacak_is)
    }
}