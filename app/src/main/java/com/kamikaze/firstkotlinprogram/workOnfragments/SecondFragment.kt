package com.kamikaze.firstkotlinprogram.workOnfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import com.kamikaze.firstkotlinprogram.R
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : Fragment(R.layout.second_fragment) {
    private val link :String = "https://miro.medium.com/max/1400/1*QwyKTUNd97o3FVJFfq9S6A.png"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView3.load(link)
    }
}