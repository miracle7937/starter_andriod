package com.example.interview_prep

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interview_prep.broadcast_reciever.AirPlayModeReciever

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val  intent = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(AirPlayModeReciever(), intent)
    }
}