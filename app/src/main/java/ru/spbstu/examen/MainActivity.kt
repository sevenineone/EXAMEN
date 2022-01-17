package ru.spbstu.examen

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.util.Log

private const val SMS_REQUEST = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bReceiver = BatteryReceiver()
        val batteryFilter = IntentFilter(BatteryManager.EXTRA_LEVEL).apply {
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        registerReceiver(bReceiver, batteryFilter)

        requestPermissions(
            arrayOf("android.permission.RECEIVE_SMS", "android.permission.READ_SMS"), SMS_REQUEST
        )

        val smsReceiver = SmsReceiver()
        val smsFilter = IntentFilter(Telephony.Sms.STATUS).apply {
            addAction("android.provider.Telephony.SMS_RECEIVED")
        }
        registerReceiver(smsReceiver, smsFilter)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == SMS_REQUEST) {
            Log.i("Permission", "SMS permission")
        }
    }
}