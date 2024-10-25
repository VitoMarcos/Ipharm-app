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
            Remedio(1, "Paracetamol", null, "Dores"),
            Remedio(2, "Ibuprofeno", R.drawable.img_9, "Dor e inflamação"),
            Remedio(3, "Dipirona", R.drawable.img_4, "Dores"),
            Remedio(4, "Imosec", R.drawable.img_2, "Alguma coisa"),
            Remedio(5, "Benegripe", R.drawable.img_3, "Gripe"),
            Remedio(6, "Clonazepam", R.drawable.img_5, "Algo"),
            Remedio(7, "Creatina", R.drawable.img_7, "Projeto Ramon Dino"),
            Remedio(8, "Omeprazol", R.drawable.img_6, "Problemas no estômago")


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