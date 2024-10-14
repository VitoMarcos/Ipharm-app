package br.edu.up.ipharm


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder



class VariadoAdapter(val lista: List<Variado>): Adapter<VariadoAdapter.VariadoViewHolder>() {

    inner class VariadoViewHolder(val itemVIew: View) : ViewHolder(itemVIew){

        val txtNomeVariado: TextView = itemView.findViewById(R.id.textViewNomeVariado)
        val txtMsgVariado: TextView = itemView.findViewById(R.id.textViewMensagem)
        val txtImgVariado: ImageView = itemView.findViewById(R.id.imageViewVariado)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariadoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_lista_variados,parent,false)

        return VariadoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(VariadoHolder: VariadoViewHolder, position: Int) {
        val Variado = lista[position]
        VariadoHolder.txtNomeVariado.text = Variado.nomeVariado
        VariadoHolder.txtImgVariado.setImageResource(R.drawable.img_8)
        VariadoHolder.txtMsgVariado.text = Variado.msgVariado

    }

}