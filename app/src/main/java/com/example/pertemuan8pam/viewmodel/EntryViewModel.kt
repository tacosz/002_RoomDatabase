package com.example.pertemuan8pam.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan8pam.repositori.RepositoriSiswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel()
{
    /**
     * Berisi status siswa saat ini
     */
    var uiStatSiswa by mutableListOf(UIStateSiswa())
        private set
}