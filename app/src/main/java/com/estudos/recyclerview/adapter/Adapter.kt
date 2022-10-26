package com.estudos.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.estudos.recyclerview.databinding.AdapterListaBinding
import com.estudos.recyclerview.model.Filme


class Adapter(private val listafilmes: ArrayList<Filme>, private val context: Context) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private lateinit var binding: AdapterListaBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding =
            AdapterListaBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val filme = listafilmes[position]
        holder.setDetails(filme)
        holder.imMoreDescription.setOnClickListener {
            if (holder.sinopse.visibility != View.VISIBLE) {
                holder.imMoreDescription.rotation = 180F
                holder.sinopse.visibility = View.VISIBLE
            } else {
                holder.sinopse.visibility = View.GONE
                holder.imMoreDescription.rotation = 0F
            }
        }

        holder.itemView.setOnLongClickListener{
            Toast.makeText(context,holder.titulo.text as String,Toast.LENGTH_LONG).show()
            true
        }
    }

    override fun getItemCount(): Int {
        return listafilmes.size
    }

    inner class MyViewHolder(binding: AdapterListaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var titulo: TextView = binding.idTitulo
        var ano: TextView = binding.idAno
        var genero: TextView = binding.idGenero
        var sinopse: TextView = binding.idSinopse
        var imMoreDescription: ImageView = binding.idMoreDetails

        fun setDetails(filme: Filme) {
            this.titulo.text = filme.titulo
            this.ano.text = filme.ano
            this.genero.text = filme.genero
            this.sinopse.text = filme.sinopse
        }
    }
}
