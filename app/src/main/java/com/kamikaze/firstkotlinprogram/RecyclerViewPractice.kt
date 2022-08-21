package com.kamikaze.firstkotlinprogram

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_practice.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "http://universities.hipolabs.com/"

class RecyclerViewPractice : AppCompatActivity() {
    lateinit var myAdaptor: CustomAdaptor
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutMAnger: LinearLayoutManager

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_practice)

        recyclerView = findViewById(R.id.recyclerView)

        // Use When YOur Data IS Working

        recyclerView.setHasFixedSize(true)
        linearLayoutMAnger = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutMAnger
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE


        GlobalScope.launch {
            val retrofitBuilder =
                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(Get_Data_APi_UNiversity::class.java)
            val retrofitData = retrofitBuilder.getData()
            retrofitData.enqueue(object : Callback<ArrayList<ResponseItem>?> {

                override fun onResponse(
                    call: Call<ArrayList<ResponseItem>?>,
                    response: Response<ArrayList<ResponseItem>?>
                ) {

                    if (response.body() != null) {
                        progressBar.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE
                        val responseBody = response.body()!!

                        Log.e("TAG", "ResponseBody: $responseBody")
                        myAdaptor = CustomAdaptor(baseContext, responseBody)

                        // myAdaptor.notifyDataSetChanged()
                        recyclerView.adapter = myAdaptor
                    }
                }

                override fun onFailure(call: Call<ArrayList<ResponseItem>?>, t: Throwable) {
                    Log.e("TAG", "onFailure: " + t.message)
                    Toast.makeText(this@RecyclerViewPractice, t.message, Toast.LENGTH_SHORT).show()
                }


            })
        }

    }


}


