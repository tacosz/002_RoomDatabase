package com.example.pertemuan8pam.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan8pam.repositori.RepositoriSiswa

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUiState StateFLow<HomeUiState> = repositoriSiswa.getAllSiswaStream
    ()
    .filterNotNull()
    .map {HomeUiState(listSiswa = it.toList())}
    .stateIn(scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
        initialValue = HomeUiState())

}