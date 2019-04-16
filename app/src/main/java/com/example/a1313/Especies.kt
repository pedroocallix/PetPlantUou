package com.example.a1313

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_especies.*


class Especies : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especies)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,Page3::class.java)
        startActivity(intent)
    }


    fun ClickDetonador(view: View)
    {
        val ch = 'a'
        val bt = ch.toByte()
        val intent: Intent = Intent(this,Page3::class.java)
        intent.putExtra("txtPersonagem",heroi1.text.toString())
        startActivity(intent)
        fun mudarImagem(imageView: ImageView){
            imageView.setImageResource(R.drawable.suculenta)
        }

        //intent.putExtra("imagemPersonagem"!; R.drawable.detonador)

    }
    fun ClickMago(view: View) {
        val ch = 'b'
        val bt = ch.toByte()
        val intent: Intent = Intent(this,Page3::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.mago)
        intent.putExtra("txtPersonagem",heroi2.text.toString())
        startActivity(intent)
        fun mudarImagem(imageView: ImageView){
            imageView.setImageResource(R.drawable.led)
        }
    }
    fun ClickNebulosa(view: View) {
        val ch = 'c'
        val bt = ch.toByte()
        val intent: Intent = Intent(this,Page3::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.nebulosa)
        intent.putExtra("txtPersonagem",heroi3.text.toString())
        startActivity(intent)
        fun mudarImagem(imageView: ImageView){
            imageView.setImageResource(R.drawable.samambaia)
        }
    }
    fun ClickSniper(view: View) {
        val ch = 'd'
        val bt = ch.toByte()
        val intent: Intent = Intent(this,Page3::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.sniper)
        intent.putExtra("txtPersonagem",heroi4.text.toString())
        startActivity(intent)
        fun mudarImagem(imageView: ImageView){
            imageView.setImageResource(R.drawable.lanca_de_sao_jorge)
        }
    }

}


