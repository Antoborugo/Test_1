package com.example.test_1

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.tasks.Task
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val signUpButton = findViewById<Button>(R.id.signup_button)

        signUpButton.setOnClickListener {
            // Navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val signInButton = findViewById<Button>(R.id.googlebutton)
        signInButton.setOnClickListener {
            signIn()
        }

// Add this to your onCreate method
        val forgotPasswordButton = findViewById<Button>(R.id.forgot_password)
        forgotPasswordButton.setOnClickListener {
            val email = findViewById<Button>(R.id.email).text.toString()
            if (email.isNotEmpty()) {
                Firebase.auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Reset link sent to your email.", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Unable to send reset mail.", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter your email.", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        } else {
            Log.e("MainActivity", "Result not OK")
        }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
            } else {
                Log.e("MainActivity", "Account is null")
            }
        } else {
            Toast.makeText(this, "Google sign in failed:(", Toast.LENGTH_LONG).show()
            Log.e("MainActivity", "Google sign in failed")
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    if (!isActivityRunning(MainActivity2::class.java)) {
                        startActivity(Intent(this, MainActivity2::class.java))
                    }
                } else {
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_LONG).show()
                    Log.e("MainActivity", "Authentication failed")
                }
            }
    }

    private fun isActivityRunning(activityClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val tasks = activityManager.getRunningTasks(Int.MAX_VALUE)
        for (taskInfo in tasks) {
            if (activityClass.name == taskInfo.topActivity?.className) {
                return true
            }
        }
        return false
    }
}
