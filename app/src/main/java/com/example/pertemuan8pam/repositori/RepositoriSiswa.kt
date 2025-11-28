package com.example.pertemuan8pam.repositori

import com.example.pertemuan8pam.room.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}