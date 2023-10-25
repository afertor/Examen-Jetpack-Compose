package com.dam.examencompose

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var round: Int = 0
    private var isGameStarted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botones
        val buttonStartReset = findViewById<Button>(R.id.buttonStartReset)
        val buttonIncreaseRound = findViewById<Button>(R.id.buttonIncreaseRound)

        // Texto de la ronda
        val textViewRound = findViewById<TextView>(R.id.textViewRound)

        // Crea un fondo circular rojo para los botones
        val circularButtonBackground = GradientDrawable()
        circularButtonBackground.shape = GradientDrawable.OVAL
        circularButtonBackground.setColor(resources.getColor(R.color.colorRed)) // Cambia a tu color deseado

        // Aplica el fondo circular a los botones
        buttonStartReset.background = circularButtonBackground
        buttonIncreaseRound.background = circularButtonBackground

        // Establece un listener para el botón "Start/Reset"
        buttonStartReset.setOnClickListener {
            if (isGameStarted) {
                // Reiniciar el juego
                isGameStarted = false
                buttonStartReset.text = "Start"
                round = 0
            } else {
                // Iniciar el juego
                isGameStarted = true
                buttonStartReset.text = "Reset"
            }
            updateRound(textViewRound)
        }

        // Establece un listener para el botón "Aumentar Ronda"
        buttonIncreaseRound.setOnClickListener {
            if (isGameStarted) {
                round++
                updateRound(textViewRound)
            }
        }
    }

    private fun updateRound(textViewRound: TextView) {
        textViewRound.text = "Ronda: $round"
    }
}
