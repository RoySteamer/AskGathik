package com.example.askgathik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.transition.platform.MaterialSharedAxis


class Answer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val title = findViewById<TextView>(R.id.textView2)
        val answerView = findViewById<TextView>(R.id.answerView)
        val btn = findViewById<Button>(R.id.buttonAgain)
        val question : String = intent.getStringExtra("Question").toString()
        val answer="you mom, sheesh"


        window.enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply{
            duration = 1000
        }

        //window.allowEnterTransitionOverlap

        //window.exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply{
        //    duration = 1000
        //}

        val animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);

        title.startAnimation(animation)

        val animationSlow = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        animationSlow.startOffset = 1000
        val animationSlower = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        animationSlower.startOffset = 2000

        answerView.startAnimation(animationSlow)

        btn.startAnimation(animationSlower)

         //animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.moveback);
        //title.startAnimation(animation)

            if (question.isNotBlank()){
                answerView.text=getString(R.string.answer_message, question, answer)
            }



            else{
                answerView.text=getString(R.string.answer_message_default)
            }

        btn.setOnClickListener {
            finishAfterTransition()
        }
    }
}