package com.kamikaze.firstkotlinprogram.retrofit

import com.kamikaze.firstkotlinprogram.quotesdatamodel.QuotesList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int):QuotesList
}