package com.gorkemersizer.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.gorkemersizer.todoapp.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var yrepo: YapilacaklarDaoRepository): ViewModel() {
    fun guncelle(yapilacak_id: Int,yapilacak_is: String){
        yrepo.yapilacakGuncelle(yapilacak_id,yapilacak_is)
    }
}