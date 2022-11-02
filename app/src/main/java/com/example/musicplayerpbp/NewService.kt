package com.example.musicplayerpbp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class NewService : Service() {

    // declaring object of MediaPlayer
    private lateinit var player:MediaPlayer

    // execution of service will start
    // on calling this method
    // also receive the type of the button to play song accordingly
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val type = intent.getStringExtra("type")
        if (type == "instrumental") {
            player = MediaPlayer.create(this, R.raw.instrument)
        } else if (type == "nyanyian") {
            player = MediaPlayer.create(this, R.raw.nyanyi)
        } else if (type == "piano") {
            player = MediaPlayer.create(this, R.raw.piano)
        }
        player.start()
        return START_STICKY
    }

    // execution of service will stop
    // on calling this method
    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}

