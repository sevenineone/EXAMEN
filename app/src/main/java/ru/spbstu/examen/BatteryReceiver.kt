package ru.spbstu.examen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

class BatteryReceiver : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val batteryLevel = p1?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        Log.i("BATTERY_LEVEL", "Battery level: $batteryLevel")
    }
}