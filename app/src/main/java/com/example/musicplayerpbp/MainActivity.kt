package com.example.musicplayerpbp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // declaring objects of Button class
    private var start: Button? = null
    private var instrumental: Button? = null
    private var nyanyi: Button? = null
    private var piano: Button? = null
    private var stop: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assigning ID of startButton
        // to the object start
//        start = findViewById<View>(R.id.instrumental) as Button
        instrumental = findViewById<View>(R.id.instrumental) as Button
        nyanyi = findViewById<View>(R.id.nyanyian) as Button
        piano = findViewById<View>(R.id.piano) as Button

        // assigning ID of stopButton
        // to the object stop
        stop = findViewById<View>(R.id.stopButton) as Button

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        instrumental!!.setOnClickListener(this)
        nyanyi!!.setOnClickListener(this)
        piano!!.setOnClickListener(this)
        stop!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        // process to be performed
        // if start button is clicked
        // and conditionally send intent of the type
        // of the song to be played
        if (view.id == R.id.instrumental) {
            val intent = Intent(this, NewService::class.java)
            intent.putExtra("type", "instrumental")
            startService(intent)
        } else if (view.id == R.id.nyanyian) {
            val intent = Intent(this, NewService::class.java)
            intent.putExtra("type", "nyanyian")
            startService(intent)
        } else if (view.id == R.id.piano) {
            val intent = Intent(this, NewService::class.java)
            intent.putExtra("type", "piano")
            startService(intent)
        }

        // process to be performed
        // if stop button is clicked
        else if (view === stop) {
            // stopping the service
            stopService(Intent(this, NewService::class.java))
        }
    }
}
