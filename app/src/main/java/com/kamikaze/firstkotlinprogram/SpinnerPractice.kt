package com.kamikaze.firstkotlinprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_spinner_practice.*

class SpinnerPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_practice)
spinner2.onItemSelectedListener =object:AdapterView.OnItemSelectedListener{
    override fun onItemSelected(adaptorview: AdapterView<*>?, view: View?, postion : Int, id: Long) {
appCompatButton.text = adaptorview?.getItemAtPosition(postion).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this@SpinnerPractice,"Nothing Selected",Toast.LENGTH_LONG).show()
    }
}

    }
}