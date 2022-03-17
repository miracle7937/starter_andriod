package com.example.interview_prep.broadcast_reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlayModeReciever: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
    Toast.makeText(p0, "Change on the Flight mode broadcast", Toast.LENGTH_LONG).show()
    }
}


///onstartcommnad


//onbind service

//unbind service


//rebind service

//onCreate
// 0nDistroy

//START_STICKY start without intent
//START_NOT_STICKY dosent start
// START_REDELIVER_INTENT  resttart and delive the same intent