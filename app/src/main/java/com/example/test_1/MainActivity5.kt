package com.example.test_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val secondActbutton = findViewById<Button>(R.id.backbutton)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this, MainActivity3::class.java)
            startActivity(Intent)
        }
    }
}