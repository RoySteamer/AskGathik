package com.example.askgathik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Answer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        val answer="you mom, sheesh "
        val question=intent.getStringExtra("Question")
        val answerView = findViewById<TextView>(R.id.answerView)
        answerView.text="The answer to "+question+" is, \n"+answer


    }
}