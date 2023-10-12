package com.example.kalkulator_imt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kalkulator_imt.databinding.ActivityLoginBinding
import com.example.kalkulator_imt.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {

    private  lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent = Intent(this@signup ,login::class.java)
            startActivity(intent)
        }
        binding.btnsignup.setOnClickListener {
            val intent = Intent(this@signup ,login::class.java)
            startActivity(intent)
            Toast.makeText(this, "Berhasil sign up !", Toast.LENGTH_SHORT).show()
        }
    }
}