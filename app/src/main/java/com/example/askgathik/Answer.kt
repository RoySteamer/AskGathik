package com.example.askgathik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


class Answer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val answer="you mom, sheesh"
        val question=intent.getStringExtra("Question")
        val answerView = findViewById<TextView>(R.id.answerView)
        answerView.text=getString(R.string.answer_message, question, answer)

        val btn = findViewById<Button>(R.id.buttonAgain)
        btn.setOnClickListener {
            finish()
        }
    }
}