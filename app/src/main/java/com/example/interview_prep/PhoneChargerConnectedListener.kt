package com.example.interview_prep

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PhoneChargerConnectedListener: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED == action){
            Toast.makeText(context, "BroadCast working", Toast.LENGTH_SHORT).show();
        }
    }
}