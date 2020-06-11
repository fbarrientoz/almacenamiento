package com.uabc.edu.almacenamiento

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMenu1.setOnClickListener {
            val intento1 = Intent(this, AlmacenamientoLocal::class.java)
            startActivity(intento1)
        }

        btnMenu2.setOnClickListener {
            val intento2 = Intent(this, AlmacenamientoSD::class.java)
            startActivity(intento2)
        }

        btnMenu3.setOnClickListener {
            val intento3 = Intent(this, AlmacenamientoSP::class.java)
            startActivity(intento3)
        }

        btnMenu4.setOnClickListener {
            val intento4 = Intent(this, AlmacenamientoSP_2::class.java)
            startActivity(intento4)
        }
    }
}
