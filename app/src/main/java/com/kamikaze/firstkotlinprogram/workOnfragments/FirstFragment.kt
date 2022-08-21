package com.kamikaze.firstkotlinprogram.workOnfragments

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kamikaze.firstkotlinprogram.R
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : Fragment(R.layout.first_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addcontactDilog = AlertDialog.Builder(activity).setTitle("add Contact")
            .setMessage("Do YOu wanna go to the Second screen")
            .setIcon(R.drawable.ic_action_name_arrow)
            .setPositiveButton("Yes") { _, _ ->
//                val snack = Snackbar.make(textView,"on second page",Snackbar.LENGTH_LONG)
//                snack.show()
                onSNACK(button2)
                startActivity(Intent(activity,SecondFragment::class.java))
            }.create()


        button2.setOnClickListener(View.OnClickListener {
            addcontactDilog.show()

        })
    }


    fun onSNACK(view: View) {
        //Snackbar(view)
        val snackbar = Snackbar.make(
            view, "On Second Page",
            Snackbar.LENGTH_LONG
        ).setAction("Action", null)
        snackbar.setActionTextColor(Color.BLUE)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(Color.LTGRAY)
        val textView =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.BLUE)
        textView.textSize = 28f
        snackbar.show()
    }
}