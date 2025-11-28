package com.example.pertemuan8pam.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan8pam.repositori.RepositoriSiswa

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

}