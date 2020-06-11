package com.uabc.edu.almacenamiento

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_almacenamiento_s_p_2.*

class AlmacenamientoSP_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenamiento_s_p_2)

        val preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE)
        btnGrabar.setOnClickListener{
            val editor = preferencias.edit()
            editor.putString(et1.text.toString(), et2.text.toString())
            editor.commit()
            Toast.makeText(this, "Datos grabados", Toast.LENGTH_LONG).show()
            et1.setText("")
            et2.setText("")
        }
        btnRecuperar.setOnClickListener {
            val datos = preferencias.getString(et1.text.toString(), "")
            if (datos!!.isEmpty())
                Toast.makeText(this, "No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show()
            else
                et2.setText(datos)
        }
    }
}
