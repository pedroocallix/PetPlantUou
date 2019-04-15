package com.example.a1313

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Configuracoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)
    }

    fun ClickPerfil (view: View) {
        var intent:Intent=Intent ( this, EditarPerfil1::class.java)
        startActivity(intent)
    }
}
