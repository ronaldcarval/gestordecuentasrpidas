package com.example.gestordecuentasrpidas.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestordecuentasrpidas.R

class CuentaAdapter (private var mesas: List<Mesa>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<CuentaAdapter.CuentaViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(mesa: Mesa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuentaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mesa, parent, false)
        return CuentaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuentaViewHolder, position: Int) {
        val mesa = mesas[position]
        holder.numeroMesaTextView.text = "Mesa ${mesa.numero}"
        holder.meseroTextView.text = "Mesero: ${mesa.mesero}"
        holder.totalCuentaTextView.text = "Total: $${mesa.cuenta.total}"

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(mesa)
            notifyItemChanged(position, mesa)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return mesas.size
    }

    fun updateMesas(newMesas: List<Mesa>) {
        mesas = newMesas
        notifyDataSetChanged()
    }

    class CuentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numeroMesaTextView: TextView= itemView.findViewById(R.id.numeroMesaTextView)
        val meseroTextView: TextView = itemView.findViewById(R.id.meseroTextView)
        val totalCuentaTextView: TextView = itemView.findViewById(R.id.totalCuentaTextView)
    }
}