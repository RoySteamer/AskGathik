package com.example.askgathik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.makeText
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onAsk(view: View) {
        val question : String = findViewById<EditText>(R.id.enterQuestion).text.toString()
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
            Snackbar.make(view, "Please Enter a Valid Question", Snackbar.LENGTH_SHORT).show()

        }

    }
}
