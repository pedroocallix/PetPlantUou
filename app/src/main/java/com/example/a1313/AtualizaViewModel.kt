package com.example.a1313

import android.app.AlertDialog
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.util.Log
import java.io.IOException
import java.util.*

object AtualizaViewModel:ViewModel() {
    private var mConnectThread: ConnectThread? = null
    var executandoThread=true
    internal var mConnectedThread: ConnectedThread? = null
    lateinit var mDevice:BluetoothDevice
    lateinit var mBluetoothAdapter: BluetoothAdapter
    var mHandler: MHandler? = null

    //Configuração do dispostivo
    val HC05_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    val DISPOSITIVO_NOME="ROGERBLUE"
    val DISPOSITIVO_MAC="98:D3:51:F5:D7:61"



    val DadosBluetooth = MutableLiveData<String>()
    fun DadosBluetooth(str: String) {
        DadosBluetooth.value = str
    }
    fun DadosBluetooth(): String{
        Log.d("mer","o que deveria vir "+DadosBluetooth.value.toString())
        return DadosBluetooth.value.toString()
    }

    fun EnviarDados(c:Char)
    {
        mConnectedThread?.write(c.toByte())
    }

    init{
        Log.d("mer","Inicializou")
        mHandler=MHandler()
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        //obtem os dispositivos pareados
        val pairedDevices = mBluetoothAdapter!!.getBondedDevices()
        var dispositivo_encontrado: BluetoothDevice?=null
        if (pairedDevices.size > 0) {
            //dispositivo_encontrado=verificaNome(pairedDevices)//procura por nome
            if(dispositivo_encontrado==null)
                dispositivo_encontrado=verificaMAC(pairedDevices)//procura por id
        }
        if(dispositivo_encontrado!=null) {
            mDevice=dispositivo_encontrado
        }

        mConnectThread = ConnectThread(mDevice)
        mConnectThread!!.start()
    }

    fun verificaNome( pd:Set<BluetoothDevice>):BluetoothDevice?{
        for(device in pd)
            if(device.name== DISPOSITIVO_NOME)
                return device

        return null
    }
    fun verificaMAC( pd:Set<BluetoothDevice>):BluetoothDevice?{
        for(device in pd)
            if(device.address== DISPOSITIVO_MAC)
                return device

        return null
    }





}