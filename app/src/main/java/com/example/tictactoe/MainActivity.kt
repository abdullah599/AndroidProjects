package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val tv1=findViewById<EditText>(R.id.editText1)
        val tv2=findViewById<EditText>(R.id.editText2)
        val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener(){
            if(tv1!=tv2 && tv1.text.toString()!="" && tv2.text.toString()!=""){
                var p1= tv1.text.toString()
                var p2= tv2.text.toString()

                val i = Intent(this, MainGame::class.java)
                i.putExtra("Player1",p1)
                i.putExtra("Player2",p2)
                startActivity(i)
                setContentView(R.layout.activity_main_game)


            }
            else{
                Toast.makeText(this, "Enter Valid Names", Toast.LENGTH_SHORT).show()
            }

        }
    }



}
