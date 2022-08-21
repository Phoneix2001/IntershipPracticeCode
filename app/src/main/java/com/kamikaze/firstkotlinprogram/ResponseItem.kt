package com.kamikaze.firstkotlinprogram

data class ResponseItem(
    val alpha_two_code: String,
    val country: String,
    val domains: ArrayList<String>,
    val name: String,
    val web_pages: ArrayList<String>
)