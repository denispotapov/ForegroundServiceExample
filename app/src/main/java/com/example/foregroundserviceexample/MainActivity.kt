package com.example.foregroundserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foregroundserviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartService.setOnClickListener {
            val input = binding.editTextInput.text.toString()

            val serviceIntent = Intent(this, ExampleService::class.java)
            serviceIntent.putExtra("key", input)
            startService(serviceIntent)

        }

        binding.btnStopService.setOnClickListener {
            val serviceIntent = Intent(this, ExampleService::class.java)
            stopService(serviceIntent)
        }
    }
}