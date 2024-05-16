package com.example.test_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val secondActbutton = findViewById<Button>(R.id.next3)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity5::class.java)
            startActivity(Intent)
        }
    }
}