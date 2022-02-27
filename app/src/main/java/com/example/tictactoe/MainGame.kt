package com.example.tictactoe

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tictactoe.databinding.ActivityMainGameBinding
import java.util.logging.XMLFormatter


class MainGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)

        //binding
        lateinit var binding: ActivityMainGameBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_game)
        //text variable
        var text = findViewById<TextView>(R.id.textViewM2)
        var p1: String? = ""
        var p2: String? = ""
        var winner: String? = ""

        //Game Functions
//For resetting
        fun Reset() {
            //Game logic
            var turn = false
            var xo = "X"

            text.setText("$p1 Turn")
            binding.button1.setText("")
            binding.button2.setText("")
            binding.button3.setText("")
            binding.button4.setText("")
            binding.button5.setText("")
            binding.button6.setText("")
            binding.button7.setText("")
            binding.button8.setText("")
            binding.button9.setText("")

        }

        //For checking wining condition
        fun Check(): Boolean {
            //Horizontal
            if (binding.button1.text.toString() == binding.button2.text.toString() && binding.button2.text.toString() == binding.button3.text.toString() && binding.button1.text.toString() != "") {
                return true
            } else if (binding.button4.text.toString() == binding.button5.text.toString() && binding.button6.text.toString() == binding.button4.text.toString() && binding.button4.text.toString() != "") {
                return true
            } else if (binding.button7.text.toString() == binding.button8.text.toString() && binding.button8.text.toString() == binding.button9.text.toString() && binding.button7.text.toString() != "") {
                return true
            }
            //Diagonal
            else if (binding.button1.text.toString() == binding.button5.text.toString() && binding.button5.text.toString() == binding.button9.text.toString() && binding.button1.text.toString() != "") {
                return true
            } else if (binding.button3.text.toString() == binding.button5.text.toString() && binding.button5.text.toString() == binding.button7.text.toString() && binding.button7.text.toString() != "") {
                return true
            }

            //Vertical
            else if (binding.button1.text.toString() == binding.button4.text.toString() && binding.button4.text.toString() == binding.button7.text.toString() && binding.button7.text.toString() != "") {
                return true
            } else if (binding.button2.text.toString() == binding.button5.text.toString() && binding.button5.text.toString() == binding.button8.text.toString() && binding.button8.text.toString() != "") {
                return true
            } else if (binding.button3.text.toString() == binding.button6.text.toString() && binding.button6.text.toString() == binding.button9.text.toString() && binding.button9.text.toString() != "") {
                return true
            }
            else if(binding.button1.text.toString() != ""&& binding.button2.text.toString() != ""&& binding.button3.text.toString() != ""&& binding.button4.text.toString() != ""&& binding.button5.text.toString() != ""&& binding.button6.text.toString() != ""&& binding.button7.text.toString() != ""&& binding.button8.text.toString() != ""&& binding.button9.text.toString() != "")
            {
                Reset()
                val i = Intent(this, End::class.java)
                i.putExtra("Winner","Draw")
                i.putExtra("Player1",p1)
                i.putExtra("Player2",p2)
                startActivity(i)
                setContentView(R.layout.activity_end)
            }


            return false
        }


        fun end() {
            Reset()
            val i = Intent(this, End::class.java)
            i.putExtra("Winner",winner)
            i.putExtra("Player1",p1)
            i.putExtra("Player2",p2)
            startActivity(i)
            setContentView(R.layout.activity_end)
        }


        //Getting data from prev Activity
        val extras = intent.extras
        if (extras != null) {
            p1 = extras.getString("Player1")
            p2 = extras.getString("Player2")
        }

        //Game logic
        var turn = false
        var xo = "X"


        text.setText("$p1's Turn")










        binding.button1.setOnClickListener() {

            if(binding.button1.text.toString()=="X"||binding.button1.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button1.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p1
                } else
                    winner = p2
                end()
            }

            turn = !turn
        }

        binding.button2.setOnClickListener() {
            if(binding.button2.text.toString()=="X"||binding.button2.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button2.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button3.setOnClickListener() {
            if(binding.button3.text.toString()=="X"||binding.button3.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button3.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button4.setOnClickListener() {
            if(binding.button4.text.toString()=="X"||binding.button4.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button4.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button5.setOnClickListener() {
            if(binding.button5.text.toString()=="X"||binding.button5.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button5.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button6.setOnClickListener() {
            if(binding.button6.text.toString()=="X"||binding.button6.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button6.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button7.setOnClickListener() {
            if(binding.button7.text.toString()=="X"||binding.button7.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button7.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button8.setOnClickListener() {
            if(binding.button8.text.toString()=="X"||binding.button8.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button8.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }
        binding.button9.setOnClickListener() {
            if(binding.button9.text.toString()=="X"||binding.button9.text.toString()=="O"){
                return@setOnClickListener
            }
            if (turn == false) {
                text.setText("$p2's Turn")
                xo = "X"

            } else {
                text.setText("$p1's Turn")
                xo = "O"
            }

            binding.button9.setText(xo)
            if (Check()) {
                if (turn) {
                    winner = p2
                } else
                    winner = p1
                end()
            }
            turn = !turn
        }


    }

    override fun onBackPressed() {

    }


}