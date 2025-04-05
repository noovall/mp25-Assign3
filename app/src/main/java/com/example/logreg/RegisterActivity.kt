package com.example.logreg

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Simpan data ke SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("Name", name)
                editor.putString("Email", email)
                editor.putString("Password", password)
                editor.apply()

                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                // Kembali ke LoginActivity
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}