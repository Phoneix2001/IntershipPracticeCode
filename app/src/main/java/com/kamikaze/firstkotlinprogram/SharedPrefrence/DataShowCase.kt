package com.kamikaze.firstkotlinprogram.SharedPrefrence

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kamikaze.firstkotlinprogram.R
import kotlinx.android.synthetic.main.activity_data_show_case.*


class DataShowCase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_show_case)
        //name ,aadharCard, emails, numBerss
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val numbers = intent.getStringExtra("Numbers")
        val aadharcard = intent.getStringExtra("aadharcard")
        name.text = username
        aadharCard.text = aadharcard
        emails.text = email
        numBerss.text = numbers
Load.setOnClickListener {
    val sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
    val usrname = sharedPreferences.getString("username", "")
    val email = sharedPreferences.getString("email", "")
    val numbers = sharedPreferences.getString("Numbers", "")
    val aadharcard = sharedPreferences.getString("aadharcard", "")
    name.text = usrname
    aadharCard.text = aadharcard
    emails.text = email
    numBerss.text = numbers
}
    }
}