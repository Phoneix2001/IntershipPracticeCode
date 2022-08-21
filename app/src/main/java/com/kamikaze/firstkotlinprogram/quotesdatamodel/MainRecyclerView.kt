package com.kamikaze.firstkotlinprogram.quotesdatamodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamikaze.firstkotlinprogram.MoreMenuFactory
import com.kamikaze.firstkotlinprogram.databinding.ActivityMainRecyclerViewBinding
import com.skydoves.powermenu.kotlin.powerMenu
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main_recycler_view.*



@AndroidEntryPoint
class MainRecyclerView : AppCompatActivity() {
    private val moreMenu by powerMenu<MoreMenuFactory>()
   private lateinit var quoatesViewModel: QuoatesViewModel
    private lateinit var adaptor: QuotesPagingAdaptor

private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityMainRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moreMenu.showAsDropDown(binding.button)
        binding.button.setOnClickListener {
            moreMenu.showAsDropDown(it)
        }

        moreMenu.setOnMenuItemClickListener { position, item ->
            moreMenu.selectedPosition = position
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView3.layoutManager = linearLayoutManager
        recyclerView3.setHasFixedSize(true)
        quoatesViewModel = ViewModelProvider(this)[QuoatesViewModel::class.java]
        adaptor = QuotesPagingAdaptor()

        recyclerView3.adapter = adaptor

        quoatesViewModel.list.observe(this , Observer {
            adaptor.submitData(lifecycle,it)
        })
    }
}