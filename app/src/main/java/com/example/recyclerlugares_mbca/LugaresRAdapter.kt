package com.example.recyclerlugares_mbca

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerlugares_mbca.databinding.LuListItemBinding
import java.security.AccessControlContext


class LugaresRAdapter(var listaLugares: MutableList<Lugares>):RecyclerView.Adapter<LugaresRAdapter.LugaresRAdapterVH>(){
    lateinit var onItemClickListener: (Lugares) -> Unit
    inner class LugaresRAdapterVH(itemView: View):RecyclerView.ViewHolder(itemView){
        private val binding: LuListItemBinding = LuListItemBinding.bind(itemView)
        fun bind(objetoLugar: Lugares){
            binding.tvLugar.text = objetoLugar.lugar
            binding.tvEstablecimiento.text = objetoLugar.establecimiento
            binding.root.setOnClickListener {
                if(::onItemClickListener.isInitialized){
                    onItemClickListener(objetoLugar)
                }
                else{
                    println("NO INICIALIZADO")
                }
            }




            //binding.tvEstablecimiento.setOnClickListener { println("Diste click a ${objetoLugar.establecimiento.toString()}") }
            //binding.tvLugar.setOnClickListener { println("El establecimiento ${objetoLugar.establecimiento.toString()} pertenece a la ciudad de ${objetoLugar.lugar.toString()}") }

        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresRAdapterVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lu_list_item, parent, false)
        return LugaresRAdapterVH(view)


    }

    override fun getItemCount(): Int {
        return listaLugares.size
    }

    override fun onBindViewHolder(holder: LugaresRAdapterVH, position: Int) {
        val lugar = listaLugares[position]
        holder.bind(lugar)

    }


}