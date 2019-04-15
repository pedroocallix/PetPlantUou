package com.example.a1313


import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.io.IOException

class ConnectThread: Thread {
    var mmSocket: BluetoothSocket?;
    var mmDevice: BluetoothDevice?;
    val viewModel= AtualizaViewModel

    //val HC05_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    constructor (device: BluetoothDevice) {
        var tmp: BluetoothSocket? = null;
        mmDevice = device;
        try {
            tmp = device.createRfcommSocketToServiceRecord(viewModel.HC05_UUID);
        } catch (e: IOException) {
            Log.d("mer","erro para criar o socket")

        }
        mmSocket = tmp;
    }

    override fun run() {
        viewModel.mConnectedThread = null;
        viewModel.mBluetoothAdapter!!.cancelDiscovery()
        try {
            Log.d("mer","Estado do socket antes da conexao "+mmSocket)

            mmSocket!!.connect();


            Log.d("mer","Estado do socket "+mmSocket)
            viewModel.mConnectedThread =ConnectedThread (mmSocket!!)
            Log.d("mer","Criação da Connected "+viewModel.mConnectedThread)
            viewModel.mConnectedThread!!.start()
        } catch (connectException: IOException) {
            Log.d("mer","deu ruim "+connectException)
            try {
                mmSocket!!.close();
            } catch (closeException: IOException) {

                Log.d("mer","erro ao iniciar o controle")
                cancel()

            }
            return;
        }
    }

    public fun cancel() {
        try {
            mmSocket!!.close()
        } catch (e: IOException) {
        }

    }
}