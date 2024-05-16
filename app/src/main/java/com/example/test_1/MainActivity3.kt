package com.example.test_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val secondActbutton = findViewById<Button>(R.id.next2)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity4::class.java)
            startActivity(Intent)
        }
    }
}