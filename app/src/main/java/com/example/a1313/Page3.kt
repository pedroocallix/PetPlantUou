package com.example.a1313

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_page3.*

class Page3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        val viewModel = AtualizaViewModel
        val i = intent
        recebeNome.text = i.getStringExtra("nomeJogador")
        recebePersonagemTexto.setText(intent.getStringExtra("txtPersonagem"))

        RetornaDados(viewModel.DadosBluetooth())
        viewModel.DadosBluetooth.observe(this, Observer {
            RetornaDados(viewModel.DadosBluetooth())
        })


    }

    fun RetornaDados(str: String?) {
        Log.d("mer", "recebendo-->" + str)
        try {
            if (str != null && str.length > 0 && str != "null") {

                val listaValores = str.split(";")
                var umidade:Double=listaValores[0].toDouble()
                var progressoUmidade:Double=umidade
                progressoUmidade=1023-progressoUmidade
                progressoUmidade/=10.23
                mf_progress_bar_azul.progress = progressoUmidade.toInt()
                mf_progress_bar_amarelo.progress = listaValores[1].toDouble().toInt()
                Log.d("mer", "pu" + mf_progress_bar_azul.progress)
                Log.d("mer", "puv" + mf_progress_bar_amarelo.progress)
            }
        }catch(e:Exception)
        {
            Log.d("mer","erro:"+e)
        }

    }

    fun ClickDicas(view: View) {

        var intent:Intent=Intent (this, Dicas::class.java)
        startActivity(intent)
    }

    fun ClickConfig(view: View) {

         var intent:Intent=Intent ( this, Configuracoes::class.java)
        startActivity(intent)
    }

    fun Click3(view: View) {

        var intent: Intent = Intent(this, Especies::class.java)
        startActivity(intent)
    }
}