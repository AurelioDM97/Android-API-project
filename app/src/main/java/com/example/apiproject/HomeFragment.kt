package com.example.apiproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apiproject.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private var currentUserNumber : Int? = null
    private var coroutine = CoroutineScope(Dispatchers.Main)

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

            val userInputNumber = binding.editTextHome.text.toString().toIntOrNull()

            if (userInputNumber != null) {
                coroutine.launch {
                    delay(2000)
                    val nextNumber = when (currentUserNumber) {
                        null -> userInputNumber + 1
                        else -> currentUserNumber!! +1
                    }
                    binding.textHome.text = nextNumber.toString()
                    currentUserNumber = nextNumber
                }
            }
        }

        return binding.root
    }
}
