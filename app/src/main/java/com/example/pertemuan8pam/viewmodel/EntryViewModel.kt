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

    private fun validasiInput(uiState: DetailSiswa = uiStatSiswa.detailSiswa
    ): Boolean{
        return with(receiver = uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUIState(detailSiswa: DetailSiswa){
        uiStatSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid =
            validasiInput(detailSiswa))
    }

    suspend fun saveSiswa(){
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(uiStatSiswa.detailSiswa.toSiswa())
        }
    }
}