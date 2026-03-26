package com.example.catalogodestinos

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtUsuario = findViewById<TextView>(R.id.txt_destino)
        val edtSenha = findViewById<TextView>(R.id.ptx_senha)
        val btnLogar = findViewById<Button>(R.id.btn_salvar)
        val btnCadastrar = findViewById<Button>(R.id.btn_registrar)


        btnCadastrar.setOnClickListener(){
            val intent = Intent(this, RegistrarView::class.java)
            startActivity(intent)
        }

        btnLogar.setOnClickListener(){
            val user = edtUsuario.text.toString()
            val senha = edtSenha.text.toString()

            if(user == "unisanta" && senha == "unisanta"){
                Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CadastroLocais::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Dados cadastrais errados", Toast.LENGTH_SHORT).show()
            }
        }



    }
}