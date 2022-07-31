package com.example.askgathik

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.platform.MaterialSharedAxis


class MainActivity : AppCompatActivity() {

    /*override fun onResume() {
        super.onResume();
        val enterQuestion = findViewById<EditText>(R.id.enterQuestion)
        enterQuestion.text.clear()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //window.enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply{
        //    duration = 1000
        //}

        window.exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true).apply {
          duration = 1000
        }

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{

            val question : String = findViewById<EditText>(R.id.enterQuestion).text.toString()

            val intent = Intent(applicationContext, Answer::class.java)
            intent.putExtra ("Question", question)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

            Handler().postDelayed({
                val enterQuestion = findViewById<EditText>(R.id.enterQuestion)
                enterQuestion.text.clear() }, 400)

        }

                //Snackbar.make(findViewById(R.id.button), "Please Enter a Valid Question", Snackbar.LENGTH_SHORT).show()
    }
}



/* TODO:
    implement more bouncy animations
    Add More People:
        Satvik
        Bavya
        Bhargav?
        Abhinay
        Karthik
        Ramesh Sir
     Jokes:
        call the person when button is pressed
        prank with sound?
    Icons for people
    NOTE:
        Animations might be a way to add a delay. Just make a animation that does nothing
        but takes some time to complete. Needs further testing

 */
