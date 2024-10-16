package br.edu.up.ipharm.DataRemedio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.edu.up.ipharm.R

class RemediosAdapter(val lista: List<Remedio>,
                      private val onImageClick: (Remedio) -> Unit): RecyclerView.Adapter<RemediosAdapter.RemedioViewHolder>() {

    inner class RemedioViewHolder(val itemVIew: View) : ViewHolder(itemVIew){


        val txtNome: TextView = itemView.findViewById(R.id.textNome)
        val txtMsg: TextView = itemView.findViewById(R.id.textMsg)
        val txtImg: ImageView = itemView.findViewById(R.id.imgFoto)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemedioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_lista,parent,false)

        return RemedioViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(RemedioHolder : RemedioViewHolder, position: Int) {

        val remedio = lista[position]
        RemedioHolder.txtNome.text = remedio.nome
        RemedioHolder.txtImg.setImageResource(R.drawable.img)
        RemedioHolder.txtMsg.text = remedio.msg

        RemedioHolder.txtImg.setOnClickListener {
            onImageClick(remedio)
        }

    }


}