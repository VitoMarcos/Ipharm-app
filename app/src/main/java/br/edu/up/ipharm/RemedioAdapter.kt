package br.edu.up.ipharm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RemedioAdapter(val lista: List<Remedio>): Adapter<RemedioAdapter.RemedioViewHolder>() {

    inner class RemedioViewHolder(val itemVIew: View) : ViewHolder(itemVIew){

        val txtNome: TextView = itemView.findViewById(R.id.textNome)
        val txtMsg: TextView = itemView.findViewById(R.id.textMsg)
        val txtImg: ImageView = itemView.findViewById(R.id.imgFoto)
        //val btnComprar: Button = itemView.findViewById(R.id.btnComprar)

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

        val Remedio = lista[position]
        RemedioHolder.txtNome.text = Remedio.nome
        RemedioHolder.txtImg.setImageResource(R.drawable.img)
        RemedioHolder.txtMsg.text = Remedio.msg
        //RemedioHolder.btnComprar.text = Remedio.comprar

    }


}