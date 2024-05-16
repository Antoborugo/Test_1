package com.example.test_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val secondActbutton = findViewById<Button>(R.id.next1)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity3::class.java)
            startActivity(Intent)
        }
    }
}