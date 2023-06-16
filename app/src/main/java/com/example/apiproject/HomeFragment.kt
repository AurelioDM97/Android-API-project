package com.example.apiproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.apiproject.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private var currentUserNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container , false)


        binding.buttonHome.setOnClickListener() {
            lifecycleScope.launch {
                delay(2000)
                val inputNumber = binding.editTextHome.text.toString().toIntOrNull()
                if (inputNumber != null) {
                    currentUserNumber = inputNumber
                    currentUserNumber++
                    binding.textHome.text = currentUserNumber.toString()
                }
            }
        }

        return binding.root
    }
}
