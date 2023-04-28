package com.example.alcoolougasolina

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23", "No onCreate, $percentual")

        // Recupera o SharedPreferences
        sharedPref = getPreferences(Context.MODE_PRIVATE)

        // Recupera o valor da variável percentual salvo, ou usa o valor padrão 0.7
        percentual = sharedPref.getFloat("percentual", 0.7F).toDouble()

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            calculo(percentual)
            Log.d("PDM23", "No onCreate, $percentual")
        })

        val switchPercentual = findViewById<Switch>(R.id.swPercentual)
        switchPercentual.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchPercentual.setText("75%")
                percentual = 0.75
            } else {
                switchPercentual.setText("70%")
                percentual = 0.70
            }

            // Salva o valor da variável percentual no SharedPreferences
            sharedPref.edit().putFloat("percentual", percentual.toFloat()).apply()
        }
        switchPercentual.isChecked = (percentual == 0.75)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        percentual = savedInstanceState.getDouble("percentual")
    }

    // Salva o valor da variável percentual quando a Activity for destruída
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("percentual", percentual)
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

    fun calculo(percentual: Double){



        val precoAlcool = findViewById<EditText>(R.id.precoAlcool)
        val precoGasolina = findViewById<EditText>(R.id.precoGasolina)

        if(precoAlcool.text.toString().isEmpty() || precoGasolina.text.toString().isEmpty()) {
            return
        }

        val valorAlcool = precoAlcool.text.toString().toDouble()
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
    }

}

