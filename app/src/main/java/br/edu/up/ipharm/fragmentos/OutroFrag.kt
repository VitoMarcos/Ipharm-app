package br.edu.up.ipharm.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.up.ipharm.R
import br.edu.up.ipharm.Remedio
import br.edu.up.ipharm.RemedioAdapter

class OutroFrag : Fragment() {

    lateinit var rvRemedio: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_outrofrag,
            container,
            false
        )

        rvRemedio = view.findViewById(R.id.listRemedios)

        val remedios = listOf(
            Remedio("Paracetamol", "-", "Dor de cabeça")
        )

        rvRemedio.adapter = RemedioAdapter(remedios)

        rvRemedio.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

}