package com.example.askgathik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionManager
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume();
        val enterQuestion = findViewById<EditText>(R.id.enterQuestion)
        enterQuestion.text.clear()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{

            val question : String = findViewById<EditText>(R.id.enterQuestion).text.toString()
            if (question.isNotBlank()){
                val intent = Intent(applicationContext, Answer::class.java)
            intent.putExtra("Question", question)
            startActivity(intent)
            }

            else {
            Snackbar.make(findViewById(R.id.button), "Please Enter a Valid Question", Snackbar.LENGTH_SHORT).show()

            }
        }

    }
}
