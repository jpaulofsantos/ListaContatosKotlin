package com.example.listacontatoskotlin

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

//contactAdapter será a classe responsável por gerenciar a lista de contatos


//1 criar a classe - : RecyclerView.Adapter<>()
// 3 Passar o viewholder para RecyclerView.Adapter
// 4 implementar metodos
class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //5 declarando a variavel para lista de contatos
    private val list: MutableList<Contact> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    //ContactAdapterViewHolder será responsável por gerenciar cada item da lista
    //2 criar o viewholder, primeiro passando a View para ContactAdapterViewHolder e depois passando itemView no construtor do  RecyclerView.ViewHolder
    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}