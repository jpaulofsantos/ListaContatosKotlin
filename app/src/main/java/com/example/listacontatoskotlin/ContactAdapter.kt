package com.example.listacontatoskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//contactAdapter será a classe responsável por gerenciar a lista de contatos


//1 criar a classe - : RecyclerView.Adapter<>()
// 3 Passar o viewholder para RecyclerView.Adapter
// 4 implementar metodos
//28 receber a classe ClickItemContactListener como parametro do construor do adapter
class ContactAdapter(var listener: ClickItemContactListener) : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //5 declarando a variavel para lista de contatos
    //6 - criar a classe modelo Contact
    private val list: MutableList<Contact> = mutableListOf()

    // 4 implementar metodos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        // criação da view
        //9 criar o layout contact_item e usa-lo no layout inflate
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        //10 retornar o adapterviewholder passando a view
        //30 passar list e listener (obtido do construtor do adapter)
        return ContactAdapterViewHolder(view, list, listener)
    }

    // 4 implementar metodos
    override fun getItemCount(): Int {
        return list.size
    }

    // 4 implementar metodos
    // lê os itens do array e popula o recyclerview
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        //8 - chamando o metodo bind de ContactAdapterViewHolder, passando a posição da lista (objeto Contact). Populando a view
        holder.bind(list[position])
    }

    //13 criando metodo para popular a lista
    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged() //informa que a lista foi alterada

    }

    //ContactAdapterViewHolder será responsável por gerenciar cada item da lista
    //2 criar o viewholder, primeiro passando a View para ContactAdapterViewHolder e depois passando itemView no construtor do  RecyclerView.ViewHolder
    //29 passar list e listenar
    class ContactAdapterViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder(itemView) {

        //11 - declarando variaveis, buscando pelo IDs atraves do findViewById
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private val textPhone: TextView = itemView.findViewById(R.id.textPhone)
        private val image: ImageView = itemView.findViewById(R.id.picture)

        //31 evento de clique na view/item da lista. chamando o método da interface que está implementada na MainActivity (que vem de ClickItemContactListener, que irá abrir a Intent)
        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        //7 - criando o método bind
        fun bind(contact: Contact) {
            //12 nomeando os campos usando os atributos da classe Contact
            textName.text = contact.name
            textPhone.text = contact.phone
        }
    }
}