package com.example.pertemuan8pam.view.route

interface DestinasiNavigasi {
    /**
     * Nama unik unt menentukan jalur composable
     */
    val route: String

    /**
     * String resource id yg berisi judul yg akan ditampilkan di layar halaman.
     */
    val titleRes: Int
}