package com.estudos.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudos.recyclerview.databinding.AdapterListaBinding
import com.estudos.recyclerview.model.Filme

class Adapter(private val listafilmes: ArrayList<Filme>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            AdapterListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(listafilmes[position])
    }

    override fun getItemCount(): Int {
        return listafilmes.size
    }

    inner class MyViewHolder(binding: AdapterListaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var titulo: TextView = binding.idTitulo
        private var ano: TextView = binding.idAno
        private var genero: TextView = binding.idGenero

        fun setData(filme:Filme) {
            this.titulo.text = filme.titulo
            this.ano.text = filme.ano
            this.genero.text = filme.genero
        }
    }
}