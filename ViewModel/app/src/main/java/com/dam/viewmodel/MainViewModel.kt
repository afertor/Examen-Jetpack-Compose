package com.dam.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private var randomNumber: Int = 0

    fun generateRandomNumber() {
        // Genera un número aleatorio entre 1 y 100
        randomNumber = Random.nextInt(1, 101)
    }

    fun getRandomNumber(): Int {
        return randomNumber
    }
}
