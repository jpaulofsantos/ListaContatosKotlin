package com.example.listacontatoskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //16 obtendo o rv do xml
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    //17
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //15
        bindView()
        updateList()
    }

    //14
    private fun bindView() {
        //18 usando o adpter no rv
        rvList.adapter = adapter
        //19 definindo a forma do rv
        rvList.layoutManager = LinearLayoutManager(this)
    }

    //20 criando uma lista fake
    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    name = "Teste1",
                    phone = "(11) 99999-9999",
                    picture = "img.jpg"
                ),
                Contact(
                    name = "Teste2",
                    phone = "(11) 90000-9999",
                    picture = "img.jpg"
                )
            )
        )
    }
}