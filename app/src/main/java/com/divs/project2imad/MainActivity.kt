package com.divs.project2imad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startbutton = findViewById<Button>(R.id.startbutton)
        startbutton.setOnClickListener {
            val intent = Intent(this, QuestionScreen::class.java)
            startActivity(intent)
            finish()
        }

    }
}