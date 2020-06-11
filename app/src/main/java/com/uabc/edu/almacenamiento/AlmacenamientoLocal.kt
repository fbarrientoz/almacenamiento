package com.uabc.edu.almacenamiento

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_almacenamiento_local.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class AlmacenamientoLocal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenamiento_local)


        if (fileList().contains("notas.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("notas.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val todo = StringBuilder()
                while (linea != null) {
                    todo.append(linea + "\n")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                etText.setText(todo)
            } catch (e: IOException) {
            }
        }

        btnGuardar.setOnClickListener {
            try {
                val archivo = OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE))
                archivo.write(et1.text.toString())
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {
            }
            Toast.makeText(this, "Los datos fueron grabados",Toast.LENGTH_SHORT).show()
            finish()
        }

        btnMenuPrincipal.setOnClickListener {
            val intento1 = Intent(this, MainActivity ::class.java)
            startActivity(intento1)
        }
    }
}
