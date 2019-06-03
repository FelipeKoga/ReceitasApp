package com.desafio.receitasapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class PesquisaActivity : AppCompatActivity() {

    lateinit var qntCarne: EditText
    lateinit var qntOvos: EditText
    lateinit var qntLeite: EditText
    lateinit var qntFarinha: EditText
    val receitasList: MutableList<Receita> = ReceitasDB().receitas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

    }

    fun retornaPesquisa(view: View) {
        val listView = findViewById<ListView>(R.id.receitas_list_view)
        var filterReceitas = ArrayList<Receita>()
        qntCarne = findViewById<EditText>(R.id.qntCarne) as EditText
        qntOvos = findViewById<EditText>(R.id.qntOvos) as EditText
        qntLeite = findViewById<EditText>(R.id.qntLeite) as EditText
        qntFarinha = findViewById<EditText>(R.id.qntFarinha) as EditText

        if (qntCarne.text.isNotEmpty() && qntOvos.text.isNotEmpty() && qntLeite.text.isNotEmpty() && qntFarinha.text.isNotEmpty()) {
            var warning = findViewById<TextView>(R.id.warning_textView)
            warning.setText("Resultado da pesquisa:")
            for (receita in receitasList) {
                if (
                    receita.qntCarne <= qntCarne.text.toString().toInt() &&
                    receita.qntOvo <= qntOvos.text.toString().toInt() &&
                    receita.qntFarinha <= qntFarinha.text.toString().toInt() &&
                    receita.qntLeite <= qntLeite.text.toString().toInt()
                ) {
                    filterReceitas.add(receita)
                }
            }
            listView.adapter = PesquisaActivity.MyCustomAdapter(this, filterReceitas)
        } else {
            var warning = findViewById<TextView>(R.id.warning_textView)
            warning.setText("Informe os dados!!!!")
        }
    }

    private class MyCustomAdapter(context: Context, receitas: ArrayList<Receita>) : BaseAdapter() {
        private val mContext: Context
        private lateinit var receitas: ArrayList<Receita>
        init {
            this.receitas = receitas
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
