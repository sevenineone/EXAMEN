package ru.spbstu.examen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent) {
        if (p1.action.equals("android.provider.Telephony.SMS_RECEIVED")) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(p1)
            for (sms in messages)
                Log.i("SMS", "SMS: $sms")
        }
    }
}