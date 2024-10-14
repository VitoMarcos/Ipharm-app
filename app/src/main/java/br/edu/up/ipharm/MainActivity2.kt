package br.edu.up.ipharm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.up.ipharm.fragmentos.OutroFrag
import br.edu.up.ipharm.fragmentos.fragVariado

class MainActivity2 : AppCompatActivity() {

    //lateinit var rvRemedio: RecyclerView
    //lateinit var btnComprar: Button

    lateinit var btnRemedio: Button
    lateinit var btnVariados: Button
    lateinit var textLista: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //rvRemedio = findViewById(R.id.listRemedios)

//        val remedios = listOf(
//            Remedio("Paracetamol", "-", "Dor de cabeça", "Comprar")
//        )

        //rvRemedio.adapter = RemedioAdapter(remedios)

        //rvRemedio.layoutManager = LinearLayoutManager(this)

        //btnComprar = findViewById(R.id.btnComprar)

        btnRemedio = findViewById(R.id.btnRemedio)
        btnVariados = findViewById(R.id.btnVariados)
        textLista = findViewById(R.id.textView4)

        btnRemedio.setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, OutroFrag())
                .commit()

            textLista.text = "Lista de remédios"
        }

        btnVariados.setOnClickListener {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragVariado())
                .commit()

            textLista.text = "Lista de variados"
        }


    }
}