package com.estudos.recyclerview.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.estudos.recyclerview.databinding.ActivityRecyclerInFragmentBinding

class RecyclerInFragment : AppCompatActivity() {

    private var _binding: ActivityRecyclerInFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var btn_voltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRecyclerInFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBindings()
        setOnClickListerners()
    }

    private fun setOnClickListerners() {
        btn_voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setBindings() {
        btn_voltar = binding.btnVoltarRvInFragment
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}