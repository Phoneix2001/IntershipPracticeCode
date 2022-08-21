package com.kamikaze.firstkotlinprogram.workOnfragments

import android.os.Bundle

import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kamikaze.firstkotlinprogram.R
import kotlinx.android.synthetic.main.third_fragment.*

class ThirdFragment :Fragment(R.layout.third_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView2)

    }
}