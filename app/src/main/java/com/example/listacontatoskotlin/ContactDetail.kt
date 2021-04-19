package com.example.listacontatoskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContactDetail : AppCompatActivity() {

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        getExtras()
        bindViews()
        initToolbar()
    }

    //36 criando a toolbar - devido ao tema principal do projeto não ter toolbar, é necessário criar uma para cada nova tela
    private fun initToolbar() {
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_view_2)
        setSupportActionBar(toolbar)
        //37 exibindo o botão voltar na toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    //34 obtendo os dados da tela que envio os dados do contato
    private fun getExtras() {
        contact = intent.getParcelableExtra("EXTRA_CONTACT")
    }

    //35 passando os dados (obtidos pelo getExtras()) para os campos da tela
    private fun bindViews() {
        findViewById<TextView>(R.id.textContact2).text = contact?.name
        findViewById<TextView>(R.id.phoneContact2).text = contact?.phone

    }

    companion object {
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    //38 metodo para fechar a activity
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}