package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.title="Mini Calculator"

//        var addbtn=findViewById<Button>(R.id.btnCal)
//        var i=0
//
//        addbtn.setOnClickListener(){
//            var text=findViewById<TextInputLayout>(R.id.textInputLayout)
//            var data=text.editText?.text.toString()
//            addbtn.setText(data)
//            var bg = findViewById<ConstraintLayout>(R.id.bg)
//            bg.setBackgroundColor(Color.parseColor(data))
//        }
        var disp = findViewById<TextView>(R.id.textView1)
        val digits = arrayOf<Button>(
            findViewById<Button>(R.id.btn0), findViewById<Button>(R.id.btn1),
            findViewById<Button>(R.id.btn2),
            findViewById<Button>(R.id.btn3),
            findViewById<Button>(R.id.btn4),
            findViewById<Button>(R.id.btn5),
            findViewById<Button>(R.id.btn6),
            findViewById<Button>(R.id.btn7),
            findViewById<Button>(R.id.btn8),
            findViewById<Button>(R.id.btn9)
        )
        val opp = arrayOf<Button>(
            findViewById<Button>(R.id.btnAdd),
            findViewById<Button>(R.id.btnSub),
            findViewById<Button>(R.id.btnMul),
            findViewById<Button>(R.id.btnDiv)
        )
        var data: String? = ""
        for (i in digits) {
            i.setOnClickListener() {

                data += i.text?.toString()
                disp.setText(data)
            }
        }
        for (i in opp) {
            i.setOnClickListener() {

                data += i.text?.toString()
                disp.setText(data)
            }
        }

        var clr=findViewById<Button>(R.id.btnClr)
        clr.setOnClickListener{
            data=disp?.text.toString()
            data=data?.dropLast(1)
            disp.setText((data))
        }
        var result = findViewById<Button>(R.id.btnCal)

        result.setOnClickListener {
            var string = disp?.text.toString()
            var valid: Boolean = false
            for (i in 1..string.length-1) {
                if (!string[i].isDigit()) {
                    valid = true
                }
            }
            if (valid) {
                var first: String = ""
                var opp: Char = '+'
                var sec: String = ""
                var separator: Int = 0
                for (i in 0..string.length) {
                    if (i == 0) {
                        first += "${string[i]}"
                    } else {
                        if (string[i].isDigit()) {
                            first += "${string[i]}"
                        } else {
                            separator = i + 1
                            opp = string[i]
                            break
                        }
                    }
                }
                for (i in separator..string.length - 1) {
                    if (string[i].isDigit()) {
                        sec += "${string[i]}"
                    } else {
                        break
                    }
                }

                var f = first.toInt()

                var s = sec.toInt()



                when (opp) {
                    '+' -> data = "${f + s}"
                    '-' -> data = "${f - s}"
                    'x' -> data = "${f * s}"
                    '/' -> {
                        if (s != 0) data = "${f / s}" else {
                            Toast.makeText(
                                applicationContext,
                                "Division by Zero not possible",
                                Toast.LENGTH_SHORT
                            ).show()
                            data=""

                        }
                    }

                }
            } else
            {Toast.makeText(applicationContext, "Enter a Valid Expression", Toast.LENGTH_SHORT)
                    .show()
            data=""
            }


            disp.setText(data)
        }

//        var mybtncal=findViewById<Button>(R.id.btnCal)
//        mybtncal.setOnClickListener(){
//            var intent: Intent = Intent(this,MainActivity2::class.java)
//            Toast.makeText(applicationContext, "We Are Going To The mOOOOON ", Toast.LENGTH_SHORT).show()
//            startActivity(intent)
//        }


    }


}