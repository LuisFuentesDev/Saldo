package com.example.saldo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.saldo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {
            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.rbSaldo -> binding.twMonto.setText(saldo.toString())

                R.id.rbIngresar -> ingresarSaldo()

                R.id.rbRetirar -> retirarSaldo()

                R.id.rbSalir -> finish()
            }
        }
    }

    private fun retirarSaldo() {
        saldo -= binding.twMonto.text.toString().toInt()
        Toast.makeText(this, "Su saldo ha sido retirado correctamente", Toast.LENGTH_SHORT).show()
    }

    fun ingresarSaldo() {
        saldo += binding.twMonto.text.toString().toInt()
        Toast.makeText(this, "Su saldo ha sido ingresado correctamente", Toast.LENGTH_SHORT).show()
    }
}