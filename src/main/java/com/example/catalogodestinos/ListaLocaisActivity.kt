package com.example.catalogodestinos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaLocaisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_locais)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_locais)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = LocaisAdapter(DadosApp.listaDeLocais) { url ->
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("URL_DESTINO", url)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}