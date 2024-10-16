package br.edu.up.ipharm.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.up.ipharm.R
import br.edu.up.ipharm.DataRemedio.Remedio
import br.edu.up.ipharm.DataRemedio.RemedioViewModel
import br.edu.up.ipharm.DataRemedio.RemediosAdapter



class OutroFrag : Fragment() {

    lateinit var rvRemedio: RecyclerView
    private lateinit var remedioViewModel: RemedioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        remedioViewModel = ViewModelProvider(this).get(RemedioViewModel::class.java)
        val view = inflater.inflate(
            R.layout.fragment_outrofrag,
            container,
            false
        )

        rvRemedio = view.findViewById(R.id.listRemedios)

        val remedios = listOf(
            Remedio("Paracetamol", "-", "Dor de cabeça"),
            Remedio("Ibuprofeno", R.drawable.img_9.toString(), "Dor e inflamação"),
            Remedio("Dipirona", R.drawable.img_4.toString(), "Dores")

        )

        rvRemedio.adapter = RemediosAdapter(remedios) { remedio ->
            adicionarAoCarrinho(remedio)
        }


        rvRemedio.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun adicionarAoCarrinho(remedio: Remedio) {
        remedioViewModel.addRemedio(remedio)
        Toast.makeText(requireContext(), "${remedio.nome} adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
    }

}