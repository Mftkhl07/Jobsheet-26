package com.example.jobsheetmita26

import Siswa
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SiswaAdapter(private val data: ArrayList<Siswa>?): RecyclerView.Adapter<SiswaAdapter.siswaViewHolder>() {

    class siswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nama = itemView.findViewById<TextView>(R.id.namaSiswa)
        private val nis = itemView.findViewById<TextView>(R.id.nisSiswa)

        fun bind(get: Siswa) {
            nama.text = get.nama
            nis.text = get.nis

            nama.setOnClickListener() {
                val intent = Intent(itemView.context, ProfilActivity::class.java)
                intent.putExtra("id", get.id)
                intent.putExtra("nama", get.nama)
                intent.putExtra("nis", get.nis)
                itemView.context.startActivity(intent)


            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SiswaAdapter.siswaViewHolder {
        return SiswaAdapter.siswaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_list_siswa, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SiswaAdapter.siswaViewHolder, position: Int) {
        holder.bind(data?.get(position) ?: Siswa("", "", ""))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0

    }
}
