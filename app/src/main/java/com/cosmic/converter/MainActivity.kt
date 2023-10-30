package com.cosmic.converter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private  var conversion : Int = 0
    private var resul: Double=0.0
    private var value: String = ""
    private lateinit var result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selectedTemp = findViewById<Spinner>(R.id.temp_options)
        val temp= findViewById<EditText>(R.id.temperatura)
        val button= findViewById<Button>(R.id.convertir)
        result = findViewById(R.id.resultado)


        if(selectedTemp != null){
            val adapter= ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_options)
            )
            selectedTemp.adapter=adapter

            selectedTemp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity, "Item seleccionado: $position", Toast.LENGTH_SHORT).show()
                    conversion = position
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // Código para cuando no se selecciona ningún elemento
                }
            }

        }

        button.setOnClickListener {

            value = temp.text.toString()
            covert(conversion)


        }

    }
    fun covert(_conversion: Int) {
        when(_conversion) {
            0 -> {
                // F = (C * 9/5) + 32
                resul= (value.toDouble() * 9/5 ) +32
                result.text= resul.toString()
            }
            1 -> {
                // K= C + 273.15
                resul = (value.toDouble()+ 273.15)
                result.text=resul.toString()
            }
            2 -> {
                // C = (F - 32) * 5/9
                resul= (value.toDouble() - 32) *5/9
                result.text=resul.toString()
            }
            3 -> {
                // (F - 32) * 5/9 + 273.15
                resul=(value.toDouble() -32) *5/9 + 273.15
                result.text=resul.toString()
            }
            4 -> {
                //C = K - 273.15
                resul=(value.toDouble()-273.15)
                result.text=resul.toString()
            }
            5 -> {
                //F = (K - 273.15) * 1.8
                resul = (value.toDouble() - 273.15) * 1.8 + 32
                result.text=resul.toString()

            }
        }
    }
}