package com.example.a1313

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.bluetooth.BluetoothAdapter
import android.os.Debug
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ClickCadastro (view: View) {
        var intent: Intent = Intent(this, Page2::class.java)
        startActivity(intent)
    }
}

