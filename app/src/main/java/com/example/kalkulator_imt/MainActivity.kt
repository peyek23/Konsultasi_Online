package com.example.kalkulator_imt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.kalkulator_imt.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    private lateinit var textViewName: TextView
    private val contentNames = arrayOf("Dokter Umum","Dokter Gigi", "Psikolog", "Farmasi", "Laboratorium")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kalkulatorimt.setOnClickListener {
            val intent = Intent(this@MainActivity , kalkulator_imt::class.java)
            startActivity(intent)
        }
        binding.pengaturan.setOnClickListener {
            val intent = Intent(this@MainActivity , pengaturan::class.java)
            startActivity(intent)
        }
        binding.lokasi.setOnClickListener {
            val intent = Intent(this@MainActivity , daftar_faskes::class.java)
            startActivity(intent)
        }

        init()

        textViewName = findViewById(R.id.tvnamaviewpager)
        // Menampilkan nama pertama sebelum inisialisasi ViewPager2
        textViewName.text = contentNames[0]

        setUpTransformer()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateName(position)
            }
        })
    }

    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init() {
        viewPager2 = findViewById(R.id.viewPager2)
        imageList = ArrayList()

        imageList.add(R.drawable.umum)
        imageList.add(R.drawable.gigi)
        imageList.add(R.drawable.psikolog)
        imageList.add(R.drawable.farmasi)
        imageList.add(R.drawable.lab)

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    private fun updateName(position: Int) {
        val currentName = contentNames[position]
        textViewName.text = currentName
    }
}

