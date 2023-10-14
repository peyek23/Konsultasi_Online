package com.example.kalkulator_imt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator_imt.databinding.ActivityLoginBinding

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.setOnClickListener {
            val intent = Intent(this@login, signup::class.java)
            startActivity(intent)
        }

        binding.btnlogin.setOnClickListener {
            val emailtext = binding.email.editText?.text.toString()
            val passwordKey = binding.password.editText?.text.toString()

            if (emailtext == "khiie257@gmail.com" && passwordKey == "123456") {
                // Jika login berhasil
                Toast.makeText(applicationContext, "Login berhasil !", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@login, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika login gagal
                Toast.makeText(applicationContext, "Login gagal", Toast.LENGTH_SHORT).show()
                val builder = AlertDialog.Builder(this@login)
                builder.setMessage("Username atau Password Anda salah!")
                    .setNegativeButton("Coba lagi", null).create().show()
            }
        }
    }
}
