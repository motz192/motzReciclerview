package com.example.recyclerlugares_mbca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerlugares_mbca.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv1.layoutManager = LinearLayoutManager(this)
        lateinit var adaptador: LugaresRAdapter



        val listaLugares:MutableList<Lugares> = mutableListOf<Lugares>()
        listaLugares.add(Lugares("01", "Misantla", "Tecnologico"))
        listaLugares.add(Lugares("02","Misantla", "Terminal"))
        listaLugares.add(Lugares("03","Misantla", "Mercado"))
        listaLugares.add(Lugares("04","Misantla", "Soriana"))
        listaLugares.add(Lugares("05","Misantla", "Bodegas"))


        adaptador = LugaresRAdapter(listaLugares)
        binding.rv1.adapter = adaptador
        binding.rv1.layoutManager = LinearLayoutManager(this)

        adaptador.onItemClickListener = {
            val intent = Intent(this, mapaReciclable::class.java)
            println(it.establecimiento.toString())
            intent.putExtra("Nombre", it.establecimiento.toString())
            startActivity(intent)
        }


















    }
}

