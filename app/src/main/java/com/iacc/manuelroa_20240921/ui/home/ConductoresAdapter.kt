package com.iacc.manuelroa_20240921.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iacc.manuelroa_20240921.R

class ConductoresAdapter(private val conductores: List<Conductor>) :
    RecyclerView.Adapter<ConductoresAdapter.ConductorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConductorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conductor, parent, false)
        return ConductorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConductorViewHolder, position: Int) {
        val conductor = conductores[position]
        holder.bind(conductor)
    }

    override fun getItemCount(): Int = conductores.size

    class ConductorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombre_conductor)
        private val viajesTextView: TextView = itemView.findViewById(R.id.viajes_conductor)
        private val imagenImageView: ImageView = itemView.findViewById(R.id.imagen_conductor)

        fun bind(conductor: Conductor) {
            nombreTextView.text = conductor.nombre
            viajesTextView.text = "Número de viajes: ${conductor.numeroViajes}"
            imagenImageView.setImageResource(conductor.imagenResId)
        }
    }
}
