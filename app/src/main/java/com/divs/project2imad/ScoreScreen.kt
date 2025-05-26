package com.divs.project2imad

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val questions = arrayOf(
            "Water expands when it freezes.",
            "The Great Wall of China is over 13,000 miles long.",
            "Goldfish have a memory span of just three seconds.",
            "Bats are blind.",
            "The capital of France is Washington DC."
        )
        val answers = booleanArrayOf(true, true, false, false, false)

        val score = intent.getIntExtra("score", 0)

        val scoretextView = findViewById<TextView>(R.id.scoretextView)
        val feedbacktextView = findViewById<TextView>(R.id.feedbacktextView)
        val reviewtextView = findViewById<TextView>(R.id.reviewtextView)
        val reviewbutton = findViewById<Button>(R.id.reviewbutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        scoretextView.text = "Your score:  $score / 5"

        feedbacktextView.text = when (score) {
            in 3..5  -> "Great job!"
            in 1..2  -> "Keep practicing!"
            else -> "Ohhhh No!"
        }

        reviewbutton.setOnClickListener {
            val builder = StringBuilder()
            for (i in questions.indices) {
                builder.append("Q${i + 1}: ${questions[i]}\n")
                builder.append("Correct Answer: ${answers[i]}\n\n")
            }
            reviewtextView.text = builder.toString()
        }

        exitbutton.setOnClickListener {
            finishAffinity()
        }

    }
}