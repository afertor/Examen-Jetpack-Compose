package com.dam.viewmodel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodellivedataexample.databinding.ActivityMainBinding
import com.example.viewmodellivedataexample.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.generateButton.setOnClickListener {
            viewModel.generateRandomNumber()
        }

        viewModel.getRandomNumber().observe(this, { number ->
            binding.randomNumberTextView.text = "Número Aleatorio: $number"
        })
    }
}
