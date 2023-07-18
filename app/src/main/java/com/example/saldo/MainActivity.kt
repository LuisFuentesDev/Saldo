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
        val monto = binding.twMonto.text.toString().toInt()
        if (monto <= saldo) {
            saldo = monto
            limpiarMonto()
            mostrarMensaje("El saldo ha sido retirado exitosamente")
        } else {
            mostrarMensaje("El monto supera el saldo inicial, intenta nuevamente")
        }


    }

    fun ingresarSaldo() {
        saldo += binding.twMonto.text.toString().toInt()
        limpiarMonto()
        mostrarMensaje("El monto se ha ingresado correctamente")
    }

    private fun limpiarMonto() {
        binding.twMonto.text.clear()
    }

    fun mostrarMensaje(s:String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}