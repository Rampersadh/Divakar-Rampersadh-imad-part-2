package com.divs.project2imad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionScreen : AppCompatActivity() {

    private val questions = arrayOf(
        "Water expands when it freezes.",
        "The Great Wall of China is over 13,000 miles long.",
        "Goldfish have a memory span of just three seconds.",
        "Bats are blind.",
        "The capital of France is Washington DC."
    )
    val answers = booleanArrayOf(true, true, false, false, false)

    var score = 0
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        val questionText = findViewById<TextView>(R.id.displayquestiontextView)
        val feedbackText = findViewById<TextView>(R.id.instantfeedbacktextView)
        val truebutton = findViewById<Button>(R.id.truebutton)
        val falsebutton = findViewById<Button>(R.id.falsebutton)
        val nextbutton = findViewById<Button>(R.id.nextbutton)

        fun updateQuestion() {
            questionText.text = questions[currentIndex]
            feedbackText.text = ""
            truebutton.isEnabled = true
            falsebutton.isEnabled = false
        }

        updateQuestion()

        truebutton.setOnClickListener {
          checkAnswer(true)
        }



        falsebutton.setOnClickListener {
            checkAnswer(false)
        }

        nextbutton.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                updateQuestion()
            }else {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("Score", score)
                startActivity(intent)
                finish()
            }
        }

        fun checkAnswer(userAnswer: Boolean) {
            val correntAnswer = answers[currentIndex]
            if (userAnswer == correntAnswer){
                score++
            }

            val feedbackTextView = findViewById<TextView>(R.id.instantfeedbacktextView)
            if (userAnswer == correntAnswer) {
                feedbackTextView.text = "Correct!"
            } else {
                feedbackTextView.text = "Incorrect!"
            }

            // Disable buttons after selection
            findViewById<Button>(R.id.truebutton).isEnabled = false
            findViewById<Button>(R.id.falsebutton).isEnabled = false
        }

    }

    private fun checkAnswer(Answer: Boolean) {

    }


}