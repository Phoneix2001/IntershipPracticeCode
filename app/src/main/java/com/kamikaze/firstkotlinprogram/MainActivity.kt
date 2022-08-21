package com.kamikaze.firstkotlinprogram

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kamikaze.firstkotlinprogram.Login.GoogleLogin
import com.kamikaze.firstkotlinprogram.SharedPrefrence.DataShowCase
import com.kamikaze.firstkotlinprogram.databaseroomdb.RoomDBMainActivity
import com.kamikaze.firstkotlinprogram.exoplayer.ExoPlayerMain
import com.kamikaze.firstkotlinprogram.navigation.NavigationMainActivity
import com.kamikaze.firstkotlinprogram.quotesdatamodel.MainRecyclerView
import com.kamikaze.firstkotlinprogram.workOnfragments.FragmentWithViewPagerAndBottomNavigationBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var isAllFieldsChecked = false
    private lateinit var reciver: AndroidInternetBrOadCastReciver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(
            crashButton, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        reciver = AndroidInternetBrOadCastReciver()
        val sharedpreferences = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        Submit.setOnClickListener {

            isAllFieldsChecked = checkAllfeilds()
            if (isAllFieldsChecked) {
                val username = username.text.toString()
                val numbers = number.text.toString()
                val emails = email.text.toString()
                val aadharx = aadharcardx.text.toString()
                editor.apply {
                    putString("username", username)
                    putString("Numbers", numbers)
                    putString("email", emails)
                    putString("aadharcard", aadharx)
                    apply()
                }
                val intent = Intent(this, DataShowCase::class.java)
                intent.putExtra("username", username)
                intent.putExtra("Numbers", numbers)
                intent.putExtra("email", emails)
                intent.putExtra("aadharcard", aadharx)
                startActivity(intent)

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_acitivit_menu, menu)

        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.spinner -> startActivity(Intent(this, SpinnerPractice::class.java))
            R.id.recyclerView -> startActivity(Intent(this, RecyclerViewPractice::class.java))
            R.id.calculator -> startActivity(Intent(this, Calculator::class.java))
            R.id.Hilt -> startActivity(Intent(this, MainRecyclerView::class.java))
            R.id.fragments -> startActivity(
                Intent(
                    this,
                    FragmentWithViewPagerAndBottomNavigationBar::class.java
                )
            )
            R.id.sharedprefrence -> startActivity(Intent(this, DataShowCase::class.java))
            R.id.exitapplication -> finishAffinity()
            R.id.navigation -> startActivity(Intent(this, NavigationMainActivity::class.java))
            R.id.diceroller -> startActivity(Intent(this, KotlinSecondPage::class.java))
            R.id.Login -> startActivity(Intent(this, GoogleLogin::class.java))
            R.id.roomdb -> startActivity(Intent(this, RoomDBMainActivity::class.java))
            R.id.exoplayer -> startActivity(Intent(this, ExoPlayerMain::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkAllfeilds(): Boolean {
        if (username!!.length() == 0) {
            username!!.error = "Username field is required"
            username!!.error = "You need to enter a name"
            return false
        }
        if (number!!.length() == 0) {
            number!!.error = "Phone Number field is required"
            return false
        }
        if (email!!.length() == 0) {
            email!!.error = "Email is required"
            return false
        }
        if (aadharcardx!!.length() == 0) {
            aadharcardx!!.error = "Aadhar Card Number is required"
            return false
        }

        // after all validation return true.
        return true

    }


}
