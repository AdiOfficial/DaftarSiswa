package com.example.daftarsiswa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarsiswa.tampildata.DataItem
import kotlinx.android.synthetic.main.activity_adapter_tampil.view.*

class AdapterTampil(

    private var data: List<DataItem?>?,
    private var context: Context,
    private val onItemClickListener: OnClickListener
) : RecyclerView.Adapter<AdapterTampil.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_adapter_tampil, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data?.get(position)

        holder.nama.text = dataItem?.namaSiswa
        holder.tangal.text = dataItem?.tangalLahir
        holder.nomertelfon.text = dataItem?.nomerTelfon
        holder.alamat.text = dataItem?.alamat


        holder.onBindviewSiswa(dataItem, position)
    }

    class ViewHolder(
        itemView: View,
        private val onItemClickListener: OnClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        val nama = itemView.nama
        val tangal = itemView.tangallahir
        val nomertelfon = itemView.nomertelfon
        val alamat = itemView.alamat


        fun onBindviewSiswa(
            dataItem: DataItem?,
            position: Int
        ) {
            itemView.setOnClickListener {
                onItemClickListener.onClick(dataItem, position)
            }
        }

    }

    interface OnClickListener {
        fun onClick(list: DataItem?, position: Int)

    }

}


