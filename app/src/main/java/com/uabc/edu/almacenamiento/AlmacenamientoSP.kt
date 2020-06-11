package com.uabc.edu.almacenamiento

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_almacenamiento_s_p.*

class AlmacenamientoSP : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenamiento_s_p)
        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        et1.setText(preferencias.getString("mail", ""))
        btnEjecutar.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString("mail", et1.text.toString())
            editor.commit()
            finish()
        }

        btnMenuPrincipal.setOnClickListener {
            val intento1 = Intent(this, MainActivity ::class.java)
            startActivity(intento1)
        }
    }
}
