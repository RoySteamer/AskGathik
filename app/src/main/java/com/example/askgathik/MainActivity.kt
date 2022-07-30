package com.example.askgathik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onAsk(view: View) {
        var question : String = findViewById<EditText>(R.id.enterQuestion).text.toString()
        if (question.isNotBlank()){

            val wholeView =
                findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.whole)
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            wholeView.startAnimation(animation)
            Executors.newSingleThreadScheduledExecutor().schedule({
                wholeView.alpha = 0f
            }, 500, TimeUnit.MILLISECONDS)


            val intent = Intent(this@MainActivity, Answer::class.java)
            intent.putExtra("Question", question)
            startActivity(intent)
        }

        else {
            Toast.makeText(this@MainActivity, "Please Enter a Valid Question", Toast.LENGTH_SHORT).show()

        }

    }
}
