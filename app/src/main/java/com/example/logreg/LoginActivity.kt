package com.example.logreg

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString()
            val inputPassword = etPassword.text.toString()

            // Ambil data yang tersimpan
            val savedEmail = sharedPreferences.getString("Email", null)
            val savedPassword = sharedPreferences.getString("Password", null)
            val savedName = sharedPreferences.getString("Name", null)

            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                // Jika login berhasil, kirim data ke LandingActivity
                val intent = Intent(this, LandingActivity::class.java)
                intent.putExtra("USER_NAME", savedName)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}