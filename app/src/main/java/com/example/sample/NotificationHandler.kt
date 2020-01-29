package com.example.sample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationHandler(private val ctx : Context ) {
    companion object {
        private const val CHANNEL_ID = "com.example.sample"
    }

    fun addNotification( conTitle:String, contText:String ) {
        val notificationManager: NotificationManager = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationIntent: Intent = Intent( ctx, ResultActivity::class.java )
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        notificationIntent.putExtra("conTitle", conTitle)
        notificationIntent.putExtra("contText", contText)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(ctx, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground )
            .setContentTitle(conTitle)
            .setContentText(contText)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = ctx.getString(R.string.app_name)
            val descriptionText = ctx.getString(R.string.app_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system

            notificationManager.createNotificationChannel(channel)

            notificationManager.notify( 1234, builder.build() )
        }

    }

}