package com.example.kalkulator_imt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator_imt.databinding.ActivityDaftarFaskesBinding

class daftar_faskes : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarFaskesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarFaskesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Temukan ImageView berdasarkan ID
        val tandaTanyaImageView: ImageView = findViewById(R.id.tanda_tanya)

        // Tambahkan event click listener pada ImageView
        tandaTanyaImageView.setOnClickListener {
            // Munculkan dialog pop-up
            showDialog("Klik untuk melihat lokasi faskes") // ** buat fitur lanjutan kalo diklik terbuka detail faskes
        }

        // Temukan linear layout berdasarkan ID
        val linear : LinearLayout = findViewById(R.id.linearinduk1)

        // Tambahkan event click listener pada linear layout
        linear.setOnClickListener {
            // Tautan langsung Google Maps yang ingin Anda buka
            val googleMapsUrl = "https://maps.app.goo.gl/FrPokJSzqeFZmpeEA"

            // Intent untuk membuka Google Maps menggunakan tautan langsung
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUrl))

            // Periksa apakah ada aplikasi yang bisa menangani intent ini
            if (mapIntent.resolveActivity(packageManager) != null) {
                // Buka Google Maps menggunakan tautan langsung
                startActivity(mapIntent)
            } else {
                // Jika tidak ada aplikasi yang bisa menangani intent ini, tampilkan pesan kepada pengguna
                Toast.makeText(this, "Google map tidak tersedia !", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun showDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setCancelable(true)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

        val alert = builder.create()
        alert.show()
    }
}
