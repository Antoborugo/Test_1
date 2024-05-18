package com.example.test_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val secondActbutton = findViewById<Button>(R.id.buttonprofpic)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity5::class.java)
            startActivity(Intent)
        }
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        imageButton.setOnClickListener {
            val Intent = Intent(this,MainActivity3::class.java)
            startActivity(Intent)
        }
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        imageButton2.setOnClickListener {
            val Intent = Intent(this,MainActivity4::class.java)
            startActivity(Intent)
        }
    }
}