package com.kamikaze.firstkotlinprogram

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage
import okhttp3.internal.notify

const val channelId = "notification_channel"
const val channelName = "com.kamikaze.firstkotlinprogram"

class MyFirebaseMessagingService : FirebaseMessagingService() {
    //genrate notification
    //attach the notification created with the custom layout


    override fun onMessageReceived(message: RemoteMessage) {
        if (message.notification != null){
genratenotification(message.notification!!.title!!, message.notification!!.body!!)
            Log.d("TAG", "onMessageReceived:  "+message.notification!!.title!!)
        }
    }
    fun genratenotification(title: String, message: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)


        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

//channel id and channel name
        var builder: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.kotlinsplash)
                .setAutoCancel(true)
                .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title,message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
    val notificationChannel = NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
    notificationManager.createNotificationChannel(notificationChannel)
    notificationManager.notify(0,builder.build())
}
    }

     @SuppressLint("RemoteViewLayout")
    private fun getRemoteView(title: String, message: String): RemoteViews? {
     val remoteview = RemoteViews("com.kamikaze.firstkotlinprogram",R.layout.notification)
        remoteview.setTextViewText(R.id.title12345,title)
        remoteview.setTextViewText(R.id.discription,message)
        remoteview.setImageViewResource(R.id.imagenew,R.drawable.kotlinsplash)

        return remoteview
    }

}
