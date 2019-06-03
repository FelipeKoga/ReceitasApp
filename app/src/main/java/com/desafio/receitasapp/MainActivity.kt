package com.desafio.receitasapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.main_list_view)
        listView.adapter = MyCustomAdapter(this)
    }

    fun pesquisaReceita(view: View) {
        val intent = Intent(this, PesquisaActivity::class.java)
        startActivity(intent)
    }


    private class MyCustomAdapter(context: Context) : BaseAdapter() {
        private val mContext: Context
        private var receitas = ReceitasDB().receitas
        init {
            this.mContext = context
        }
        override fun getItem(position: Int): Any {
            return receitas.get(position)
        }
        override fun getCount(): Int {
            println(receitas.size)
            return receitas.size
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, parent, false)

            val receitaTextView = rowMain.findViewById<TextView>(R.id.receita_textView)
            receitaTextView.text = receitas.get(position).nomeReceita
            val carneTextView = rowMain.findViewById<TextView>(R.id.carne_textView)
            carneTextView.text = receitas.get(position).qntCarne.toString()
            val farinhaTextView = rowMain.findViewById<TextView>(R.id.farinha_textView)
            farinhaTextView.text = receitas.get(position).qntFarinha.toString()
            val ovoTextView = rowMain.findViewById<TextView>(R.id.ovos_textView)
            ovoTextView.text = receitas.get(position).qntOvo.toString()
            val leiteTextView = rowMain.findViewById<TextView>(R.id.leite_textView)
            leiteTextView.text = receitas.get(position).qntLeite.toString()


            return rowMain
        }
    }
}
