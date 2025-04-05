package com.example.logreg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Ambil data nama dari Intent
        val userName = intent.getStringExtra("USER_NAME")

        tvWelcome.text = "Welcome, $userName!"

        btnLogout.setOnClickListener {
            // Kembali ke LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}