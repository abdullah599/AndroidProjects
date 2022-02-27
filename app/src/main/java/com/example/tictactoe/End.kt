package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView


class End : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        var btn = findViewById<Button>(R.id.btnEnd)

        //Getting data from prev Activity
        var W: String? = ""
        var p1: String? = ""
        var p2: String? = ""
        val extras = intent.extras

        if (extras != null) {
            W = extras.getString("Winner")
            p1 = extras.getString("Player1")
            p2 = extras.getString("Player2")

        }
        var t = findViewById<TextView>(R.id.textViewM)
        var Da = findViewById<LottieAnimationView>(R.id.animationView)
        var Wa = findViewById<LottieAnimationView>(R.id.animationView2)


        if (W != "Draw") {
            Wa.setVisibility(View.VISIBLE)
            t.setText("$W Won!")
        } else {

            Da.setVisibility(View.VISIBLE)
            t.setText("Draw!!!")
        }


        btn.setOnClickListener() {
            val i = Intent(this, MainGame::class.java)
            i.putExtra("Player1", p1)
            i.putExtra("Player2", p2)
            startActivity(i)
            setContentView(R.layout.activity_main_game)
        }
    }

    override fun onBackPressed() {

    }
}