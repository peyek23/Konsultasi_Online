package com.example.kalkulator_imt

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageAdapter(private val imageList: ArrayList<Int>, private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])

        // Menangani klik pada gambar
        holder.imageView.setOnClickListener {
            val context = holder.imageView.context
            when (position) {
                0 -> {
                    // Posisi 0 (Dokter Umum): Buka LoginActivity
                    val intent = Intent(context, daftar_umum::class.java)
                    context.startActivity(intent)
                }
                1 -> {
                    // Posisi 1 (Dokter Gigi): Buka SignUpActivity
                    val intent = Intent(context, daftar_umum::class.java)
                    context.startActivity(intent)
                }
                // Lanjutkan dengan posisi lainnya jika diperlukan
                // ...
            }
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    private val runnable = Runnable {
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }
}
