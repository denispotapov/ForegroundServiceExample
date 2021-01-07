package com.example.foregroundserviceexample

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ExampleService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra("key")

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, 0)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_android)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}