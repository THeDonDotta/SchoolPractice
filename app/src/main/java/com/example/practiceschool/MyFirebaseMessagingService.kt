package com.example.practiceschool

import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews.RemoteView
import androidx.core.app.NotificationCompat
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class MyFirebaseMessagingService: FirebaseMessagingService() {

    val tag: String = "FCMToken"

    override fun onNewToken(token: String) {
        Log.d(tag, "FCMToken: $token")

    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(tag, "Message data payload: ${remoteMessage.data}")

        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(tag, "Message Notification Body: ${it.body}")
            val notice = MyNotification(context = applicationContext, it.title.toString(), it.body.toString())
            notice.FireNotification()
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}