package com.example.catalogodestinos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroLocais : AppCompatActivity() {

    val listaDeLocais = mutableListOf<Locais>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_locais)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtDestino = findViewById<TextView>(R.id.txt_destino)
        val txtPaisRegiao = findViewById<TextView>(R.id.txt_paisregiao)
        val txtUrl = findViewById<TextView>(R.id.txt_url)
        val btnSalvar = findViewById<TextView>(R.id.btn_salvar)

        btnSalvar.setOnClickListener(){
            val destino = txtDestino.text.toString()
            val paisregiao = txtPaisRegiao.text.toString()
            val url = txtUrl.text.toString()

            if(destino.isNotEmpty() && paisregiao.isNotEmpty() && url.isNotEmpty()){
                val novoLocal = Locais(
                        nomeDestino = destino,
                        paisRegiao = paisregiao,
                        Url = url
                )

                DadosApp.listaDeLocais.add(novoLocal)

                Toast.makeText(this, "Local cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVerLista = findViewById<Button>(R.id.btn_ver_lista)

        btnVerLista.setOnClickListener {
            val intent = Intent(this, ListaLocaisActivity::class.java)
            startActivity(intent)
        }

    }
}