package com.kamikaze.firstkotlinprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculator.*
class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        button.setOnClickListener(View.OnClickListener {
            val nothin =
                editTextTextPersonName2.text.toString()
                    .toInt() + editTextTextPersonName.text.toString().toInt()
            finalAnswer.text = nothin.toString()
        })
    }
}