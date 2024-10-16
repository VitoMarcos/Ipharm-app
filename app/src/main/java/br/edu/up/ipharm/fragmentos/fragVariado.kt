package br.edu.up.ipharm.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.up.ipharm.R
import br.edu.up.ipharm.DataVariado.Variado
import br.edu.up.ipharm.DataVariado.VariadoAdapter

class fragVariado : Fragment() {

    lateinit var rvVariado: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.frag_variado,
            container,
            false
        )

        rvVariado = view.findViewById(R.id.listVariados)

        val variados = listOf(
            Variado("Gilette", "-", "Aparelho de barbear")
        )

        rvVariado.adapter = VariadoAdapter(variados)

        rvVariado.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

}