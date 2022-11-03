package com.example.musicplayerpbp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // declaring objects of Button class
    private var play: Button? = null
    private var next: Button? = null
    private var prev: Button? = null
    private var piano: Button? = null
    private var pause: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of startButton
        // to the object start
//        start = findViewById<View>(R.id.instrumental) as Button
        next = findViewById<View>(R.id.btn_next) as Button
        prev = findViewById<View>(R.id.btn_prev) as Button
        play = findViewById<View>(R.id.btn_play) as Button

        // assigning ID of stopButton
        // to the object stop
//        stop = findViewById<View>(R.id.stopButton) as Button

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        next!!.setOnClickListener(this)
        prev!!.setOnClickListener(this)
        play!!.setOnClickListener(this)
//        stop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        // process to be performed
        // if start button is clicked
        // and conditionally send intent of the type
        // of the song to be played
        if (view.id == R.id.btn_prev) {
            val intent = Intent(this, NewService::class.java)
            intent.putExtra("type", "instrumental")
            startService(intent)
        } else if (view.id == R.id.btn_play) {
            val intent = Intent(this, NewService::class.java)
            intent.putExtra("type", "nyanyian")
            startService(intent)
        } else if (view.id == R.id.btn_next) {
            val intent = Intent(this, NewService::class.java)
            intent.putExtra("type", "piano")
            startService(intent)
        }

        // process to be performed
        // if stop button is clicked
//        else if (view === stop) {
//            // stopping the service
//            stopService(Intent(this, NewService::class.java))
//        }
    }
}
