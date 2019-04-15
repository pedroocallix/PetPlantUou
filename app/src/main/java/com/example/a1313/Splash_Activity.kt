package com.example.a1313

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class Splash_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_)
        val viewModel = AtualizaViewModel
        val background = object : Thread() {
            override fun run() {
                try{
                    Thread.sleep(2500)

                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
