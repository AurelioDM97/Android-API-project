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
            //prende il testo e lo converte in int, dopodiciò toIntOrNull converte in un intero se possibile altrimenti restituisce null
            val userInputNumber = binding.editTextHome.text.toString().toIntOrNull()
            if (userInputNumber != null) {
                coroutine.launch {// qui eseguiamo un operazione asincrona dopo la verifica dell'if se la conversione è avvenuta
                    delay(2000)
                    val nextNumber = when (currentUserNumber) {
                        null -> userInputNumber + 1
                        else -> currentUserNumber!! + 1
                    }
                    withContext(Dispatchers.Main) { //chiamata che consente di eseguire il blocco di codice nel thread principale in modo più sicuro
                        binding.textHome.text = nextNumber.toString() //qui impostiamo il testo nel TextView
                    }
                    currentUserNumber = nextNumber //qui salviamo il numero corrente per fare l'iterazione successiva e incrementare di 1 quel numero
                }
            }
        }

        return binding.root
    }
}
