package ru.spbstu.examen

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bReceiver = BatteryReceiver()
        val filter = IntentFilter(BatteryManager.EXTRA_LEVEL).apply {
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        registerReceiver(bReceiver, filter)
    }
}