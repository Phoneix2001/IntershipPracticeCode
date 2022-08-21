package com.kamikaze.firstkotlinprogram

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AndroidInternetBrOadCastReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val IsAeroplaneModeEnabled = intent?.getBooleanExtra("state",false) ?:return
        if(IsAeroplaneModeEnabled){
Toast.makeText(context,"Aeroplane mode is on",Toast.LENGTH_LONG).show()
        }else Toast.makeText(context,"Aeroplane mode is off",Toast.LENGTH_LONG).show()
    }
}