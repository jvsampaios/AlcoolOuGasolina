package com.example.alcoolougasolina

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            val precoAlcool = findViewById<EditText>(R.id.precoAlcool)
            val valorAlcool = precoAlcool.text.toString().toDouble()

            val precoGasolina = findViewById<EditText>(R.id.precoGasolina)
            val valorGasolina = precoGasolina.text.toString().toDouble()

            val result = valorGasolina * percentual

            val resultado = findViewById<EditText>(R.id.resultado)

            if (valorAlcool<=result) {
                resultado.setText("Álcool é mais vantajoso")
                resultado.visibility = View.VISIBLE
                resultado.keyListener = null
            }
            else {
                resultado.visibility = View.VISIBLE
                resultado.keyListener = null
                resultado.setText("Gasolina é mais vantajoso")
            }
            Log.d("PDM23","No btCalcular, $percentual, $valorGasolina, $valorAlcool")
        })
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
}