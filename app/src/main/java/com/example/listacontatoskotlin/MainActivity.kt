package com.example.listacontatoskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.speech.RecognizerIntent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//25 criar a classe ClickItemContactListener e extender na MainActivity
class MainActivity : AppCompatActivity(), ClickItemContactListener {

    //16 obtendo o rv do xml
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    //17
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        //15
        initDrawer()
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

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    //21 menu - primeiro criar a pasta res/menu caso não tenha. Criar o arquivo xml
    //22 metodo para criar o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    //23 configurando toque no item do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Menu 1 - Teste")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Menu 2 - Teste")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //24 iniciando o Drawer
    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawer_view) as DrawerLayout
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_view)

        setSupportActionBar(toolbar)
        
        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }
    //26 implementar o método
    override fun clickItemContact(contact: Contact) {
        //27 criando a intent, passando contexto e a classe
        val intent = Intent(this, ContactDetail::class.java)
        startActivity(intent)
    }
}