package com.estudos.recyclerview.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estudos.recyclerview.adapter.Adapter
import com.estudos.recyclerview.databinding.ActivityRecyclerInActivityBinding
import com.estudos.recyclerview.model.Filme

class RecyclerInActivity : AppCompatActivity() {
    // view binding para a atividade
    private var _binding: ActivityRecyclerInActivityBinding? = null
    private val binding get() = _binding!!


    private lateinit var recyclerView: RecyclerView
    private lateinit var btnVoltar: Button
    private var listafilmes: ArrayList<Filme> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRecyclerInActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // atribui binding aos componentes da view
        setBindings()

        // atribui evento de click aos componentes da view
        setOnClickListeners()

        // Preenche a lista de filmes
        criarFilmes()

        // configura RecyclerViews da tela
        setUpRecyclerViewVertical(listafilmes)
//        setUpRecyclerViewHorizontal(listafilmes)
    }


    private fun criarFilmes() {
        listafilmes = Filme().makeData()
    }

    private fun setUpRecyclerViewHorizontal(listafilmes: ArrayList<Filme>) {
        val horizontalLayout = LinearLayoutManager(
            applicationContext, LinearLayoutManager.HORIZONTAL, false
        )
        recyclerView.layoutManager = horizontalLayout
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = Adapter(listafilmes,this)
    }

    private fun setUpRecyclerViewVertical(listafilmes: ArrayList<Filme>) {

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = Adapter(listafilmes,this)
    }

    private fun setBindings() {
        recyclerView = binding.recyclerViewInActivity
        btnVoltar = binding.btnVoltar
    }

    private fun setOnClickListeners() {
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // on destroy, a view faz:
    // referência o binding para nulo
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}