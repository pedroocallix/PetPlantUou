package com.example.a1313

import android.bluetooth.BluetoothSocket
import android.os.Handler
import android.os.Message
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception
import java.nio.charset.Charset

class ConnectedThread(private val mmSocket: BluetoothSocket) : Thread() {
    private val mmInStream: InputStream?
    private val mmOutStream: OutputStream?

    val viewModel= AtualizaViewModel

    init {
        var tmpIn: InputStream? = null
        var tmpOut: OutputStream? = null
        try {
            tmpIn = mmSocket.inputStream
            tmpOut = mmSocket.outputStream
        } catch (e: IOException) {

        }
        mmInStream = tmpIn
        mmOutStream = tmpOut

    }

    //roda indefinidamente
    override fun run() {
        var buffer:ByteArray =  ByteArray(1024)
        var begin:Int = 0
        var bytes:Int = 0
        while (viewModel.executandoThread) {
            try {
                bytes += mmInStream!!.read(buffer, bytes, buffer.size - bytes);
                for (i in begin..bytes){
                    if(buffer[i] == '#'.toByte()) {
                        var subBuffer=buffer.copyOfRange(begin,i)
                        var str=String(subBuffer, Charset.forName("UTF-8"))
                        viewModel.mHandler!!.obtainMessage(1, subBuffer).sendToTarget();
                        //viewModel.DadosBluetooth(str)
                        begin = i + 1;
                        if(i >1000) {
                            buffer =  ByteArray(1024)
                            bytes = 0;
                            begin = 0;
                        }
                    }
                }
            } catch (e: IOException) {
                cancel()
                break;
            }
        }
        cancel()
    }

    fun write(bytes: Byte) {
        try {
            mmOutStream!!.write(bytes.toInt())
        } catch (e: IOException) {
            cancel()

        }
    }
    public fun cancel() {
        try {
            Log.d("mer", "fechando")
            mmInStream!!.close()
            mmOutStream!!.close()
            mmSocket.close()

        } catch (e: IOException) {
            Log.d("mer","fechando "+e)
        }
    }
}