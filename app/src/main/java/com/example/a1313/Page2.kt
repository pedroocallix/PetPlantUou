package com.example.a1313

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_page2.*


class Page2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)




    }
    fun Click(view: View) {

        var intent: Intent = Intent(this@Page2, Page3::class.java)
        intent.putExtra("nomeJogador",nome.text.toString())
        startActivity(intent)
    }
}
