package com.kamikaze.firstkotlinprogram.quotesdatamodel

import androidx.paging.Pager
import  androidx.paging.PagingConfig
import androidx.paging.liveData
import com.kamikaze.firstkotlinprogram.retrofit.QuotesApi
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val quotesApi: QuotesApi) {

    fun getQuotes() = Pager(
       config = PagingConfig(pageSize = 20, maxSize = 100),
    pagingSourceFactory ={QuotesPagingSource(quotesApi)} ).liveData
}