package com.kamikaze.firstkotlinprogram

import retrofit2.Call
import retrofit2.http.GET

interface Get_Data_APi_UNiversity {
    @GET("search?country=India")
   fun getData() : Call<ArrayList<ResponseItem>>
}