package com.kamikaze.firstkotlinprogram.quotesdatamodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class QuoatesViewModel @Inject constructor(private  val repository :QuotesRepository):ViewModel() {
    val list = repository.getQuotes().cachedIn(viewModelScope)
}