package com.uabc.edu.almacenamiento


import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import kotlinx.android.synthetic.main.activity_almacenamiento_s_d.*

class AlmacenamientoSD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenamiento_s_d)

        btnGuardar.setOnClickListener {
            try {
                val tarjeta = Environment.getExternalStorageDirectory()
                val file = File(tarjeta.getAbsolutePath(), et1.text.toString())
                val osw = OutputStreamWriter(FileOutputStream(file))
                osw.write(et2.text.toString())
                osw.flush()
                osw.close()
                Toast.makeText(this, "Los datos fueron grabados correctamente", Toast.LENGTH_SHORT).show()
                et1.setText("")
                et2.setText("")
            } catch (ioe: IOException) {
                Toast.makeText(this, "No se pudo grabar", Toast.LENGTH_SHORT).show()
            }
        }

        btnRecuperar.setOnClickListener {
            val tarjeta = Environment.getExternalStorageDirectory()
            val file = File(tarjeta.absolutePath, et1.text.toString())
            try {
                val fIn = FileInputStream(file)
                val archivo = InputStreamReader(fIn)
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val todo = StringBuilder()
                while (linea != null) {
                    todo.append(linea + "\n")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                et2.setText(todo)

            } catch (e: IOException) {
                Toast.makeText(this, "No se pudo leer", Toast.LENGTH_SHORT).show()
            }
        }

        btnMenuPrincipal.setOnClickListener {
            val intento1 = Intent(this, MainActivity ::class.java)
            startActivity(intento1)
        }
    }
}
