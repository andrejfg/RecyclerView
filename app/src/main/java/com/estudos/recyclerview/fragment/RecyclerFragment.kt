package com.estudos.recyclerview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estudos.recyclerview.adapter.Adapter
import com.estudos.recyclerview.databinding.FragmentRecyclerBinding
import com.estudos.recyclerview.model.Filme


class RecyclerFragment : Fragment() {
    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private var listafilmes: ArrayList<Filme> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        // atribui binding aos componentes da view
        setBindings()
        return binding.root
    }

    private fun setUpRecyclerViewVertical(listafilmes: ArrayList<Filme>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        recyclerView.adapter = Adapter(listafilmes)

    }

    private fun setUpRecyclerViewHorizontal(listafilmes: ArrayList<Filme>) {
        val horizontalLayout = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        recyclerView.layoutManager = horizontalLayout
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = Adapter(listafilmes)

    }

    private fun setBindings() {
        recyclerView = binding.rvInFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // cria lista de filmes
        criarFilmes()

        // configura RecyclerViews da tela
        setUpRecyclerViewVertical(listafilmes)
//        setUpRecyclerViewHorizontal(listafilmes)
    }

    private fun criarFilmes() {
        listafilmes = Filme().makeData()
    }

    // on destroy, a view faz:
    // referência o binding para nulo
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}