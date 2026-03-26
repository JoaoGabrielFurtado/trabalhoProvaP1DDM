package com.example.catalogodestinos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LocaisAdapter(
    private val locais: MutableList<Locais>,
    private val onExplorarClick: (String) -> Unit
) : RecyclerView.Adapter<LocaisAdapter.LocalViewHolder>() {

    class LocalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDestino: TextView = view.findViewById(R.id.txt_item_destino)
        val txtPais: TextView = view.findViewById(R.id.txt_item_pais)
        val btnExplorar: Button = view.findViewById(R.id.btn_explorar)
        val btnExcluir: Button = view.findViewById(R.id.btn_excluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_local, parent, false)
        return LocalViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
        val local = locais[position]

        holder.txtDestino.text = local.nomeDestino
        holder.txtPais.text = local.paisRegiao

        holder.btnExplorar.setOnClickListener {
            onExplorarClick(local.Url)
        }

        holder.btnExcluir.setOnClickListener {
            locais.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = locais.size
}