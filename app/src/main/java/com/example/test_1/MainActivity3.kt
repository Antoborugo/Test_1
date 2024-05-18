package com.example.test_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val secondActbutton = findViewById<Button>(R.id.buttonprofpic2)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity5::class.java)
            startActivity(Intent)
        }
        val homegreybutton = findViewById<ImageButton>(R.id.homegreybutton)
        homegreybutton.setOnClickListener {
            val Intent = Intent(this,MainActivity2::class.java)
            startActivity(Intent)
        }
        val graycontrolbutton = findViewById<ImageButton>(R.id.graycontrolbutton)
        graycontrolbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity4::class.java)
            startActivity(Intent)
        }
    }
}