package com.estudos.recyclerview.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.estudos.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private lateinit var btn_rv_in_activity: Button
    private lateinit var btn_rv_in_fragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBindings()

        setOnClickListeners()
    }

    private fun setBindings() {
        btn_rv_in_activity = binding.btnRvInActivity
        btn_rv_in_fragment = binding.btnRvInFragment
    }

    private fun setOnClickListeners() {
        btn_rv_in_activity.setOnClickListener {
            val intent = Intent(this, RecyclerInActivity::class.java)
            startActivity(intent)
        }
        btn_rv_in_fragment.setOnClickListener {
            val intent = Intent(this, RecyclerInFragment::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}