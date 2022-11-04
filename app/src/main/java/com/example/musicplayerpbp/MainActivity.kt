package com.example.musicplayerpbp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // declaring objects of Button class
    private var play: Button? = null
    private var next: Button? = null
    private var prev: Button? = null
    private var piano: Button? = null
    private var pause: Button? = null
    private var songTitle: TextView? = null
    private var fotoLagu: ImageView? = null
    private lateinit var player: MediaPlayer

    //make array of songs
    private val songs = arrayOf("instrumental", "nyanyian", "piano")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // songtitle
        songTitle = findViewById(R.id.tv_songTitle)
        // imageview
        fotoLagu= findViewById(R.id.iv_musicImg)
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
        //if there is a previous song, play it
            if (songs.indexOf(songTitle!!.text) > 0) {
                val intent = Intent(this, NewService::class.java)
                intent.putExtra("type", songs[songs.indexOf(songTitle!!.text) - 1])
                startService(intent)
                songTitle!!.text = songs[songs.indexOf(songTitle!!.text) - 1]
                if (songs.indexOf(songTitle!!.text) == 0) {
                    fotoLagu!!.setImageResource(R.drawable.instrument)
                } else if (songs.indexOf(songTitle!!.text) == 1) {
                    fotoLagu!!.setImageResource(R.drawable.idnraya)
                } else if (songs.indexOf(songTitle!!.text) == 2) {
                    fotoLagu!!.setImageResource(R.drawable.piano)
                }
            }
                    //if there is a next song, play it
            if (songs.indexOf(songTitle!!.text) > 0) {
                val intent = Intent(this, NewService::class.java)
                intent.putExtra("type", songs[songs.indexOf(songTitle!!.text) - 1])
                startService(intent)
                songTitle!!.text = songs[songs.indexOf(songTitle!!.text) - 1]
                if (songs.indexOf(songTitle!!.text) == 0) {
                    fotoLagu!!.setImageResource(R.drawable.instrument)
                } else if (songs.indexOf(songTitle!!.text) == 1) {
                    fotoLagu!!.setImageResource(R.drawable.idnraya)
                } else if (songs.indexOf(songTitle!!.text) == 2) {
                    fotoLagu!!.setImageResource(R.drawable.piano)
                }
            }
            //
        } else if (view.id == R.id.btn_next) {
        //if there is a next song, play it
            if (songs.indexOf(songTitle!!.text) < songs.size - 1) {
                val intent = Intent(this, NewService::class.java)
                intent.putExtra("type", songs[songs.indexOf(songTitle!!.text) + 1])
                startService(intent)
                songTitle!!.text = songs[songs.indexOf(songTitle!!.text) + 1]
                if (songs.indexOf(songTitle!!.text) == 0) {
                    fotoLagu!!.setImageResource(R.drawable.instrument)
                } else if (songs.indexOf(songTitle!!.text) == 1) {
                    fotoLagu!!.setImageResource(R.drawable.idnraya)
                } else if (songs.indexOf(songTitle!!.text) == 2) {
                    fotoLagu!!.setImageResource(R.drawable.piano)
                }    
            }  
        } else if (view.id == R.id.btn_play) {
        //if there is no song playing, play the first song
            if (!this::player.isInitialized) {
                val intent = Intent(this, NewService::class.java)
                intent.putExtra("type", songs[0])
                startService(intent)
                songTitle!!.text = songs[0]
                fotoLagu!!.setImageResource(R.drawable.instrument)
            }  
        }  
    }   
}    
