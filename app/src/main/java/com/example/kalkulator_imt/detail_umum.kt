package com.example.kalkulator_imt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kalkulator_imt.databinding.ActivityDetailUmumBinding

class detail_umum : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUmumBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUmumBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}