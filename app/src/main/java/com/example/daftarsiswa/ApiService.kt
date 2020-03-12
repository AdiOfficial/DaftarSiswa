package com.example.daftarsiswa

import com.example.daftarsiswa.tampildata.Tampildata
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("tampil_data")
    fun daftarsiswa(): Call<Tampildata>
}