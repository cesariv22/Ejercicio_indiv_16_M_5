package com.example.ejercicio_indiv_16_m_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.example.ejercicio_indiv_16_m_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currencies = resources.getStringArray(R.array.currencies)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCurrency.adapter = adapter
        binding.spinnerCurrency2.adapter = adapter

        binding.buttonConvert.setOnClickListener {
            convert()
        }

        binding.buttonReset.setOnClickListener {
            reset()
        }
    }

    private fun convert() {
        val selectedCurrency = binding.spinnerCurrency.selectedItem.toString()
        val selectedCurrency2 = binding.spinnerCurrency2.selectedItem.toString()


        val amountText = binding.editTextAmount.text.toString()
        if (amountText.isNotEmpty()) {
            val amount = amountText.toDouble()

            val result = when  {
                selectedCurrency == "USD" && selectedCurrency2 == "USD" -> convertToUSDFromUSD(amount)
                selectedCurrency == "USD" && selectedCurrency2 == "EUR" -> convertToUSDFromEUR(amount)
                selectedCurrency == "USD" && selectedCurrency2 == "JPY" -> convertToUSDFromJPY(amount)
                selectedCurrency == "USD" && selectedCurrency2 == "CLP" -> convertToUSDFromCLP(amount)
                selectedCurrency == "EUR" && selectedCurrency2 == "EUR" -> convertToEURFromEUR(amount)
                selectedCurrency == "EUR" && selectedCurrency2 == "USD" -> convertToEURFromUSD(amount)
                selectedCurrency == "EUR" && selectedCurrency2 == "JPY" -> convertToEURFromJPY(amount)
                selectedCurrency == "EUR" && selectedCurrency2 == "CLP" -> convertToEURFromCLP(amount)
                selectedCurrency == "JPY" && selectedCurrency2 == "JPY" -> convertToJPYFromJPY(amount)
                selectedCurrency == "JPY" && selectedCurrency2 == "USD" -> convertToJPYFromUSD(amount)
                selectedCurrency == "JPY" && selectedCurrency2 == "EUR" -> convertToJPYFromEUR(amount)
                selectedCurrency == "JPY" && selectedCurrency2 == "CLP" -> convertToJPYFromCLP(amount)
                selectedCurrency == "CLP" && selectedCurrency2 == "CLP" -> convertToCLPFromCLP(amount)
                selectedCurrency == "CLP" && selectedCurrency2 == "USD" -> convertToCLPFromUSD(amount)
                selectedCurrency == "CLP" && selectedCurrency2 == "EUR" -> convertToCLPFromEUR(amount)
                selectedCurrency == "CLP" && selectedCurrency2 == "JPY" -> convertToCLPFromJPY(amount)

                else -> 0.00
            }
           // binding.textViewResult.text = "$amount $selectedCurrency = $result $selectedCurrency2" // Mostrar el resultado en USD
            binding.textViewResult.text = String.format("%.2f %s = %.2f %s", amount, selectedCurrency, result, selectedCurrency2)

        } else {
            binding.textViewResult.text = "Ingrese un monto válido."
        }
    }

    private fun reset() {
        binding.editTextAmount.text.clear()
        binding.textViewResult.text = ""
    }


    private fun convertToUSDFromUSD(amount: Double): Double {
        val exchangeRate = 1.00
        return amount * exchangeRate
    }
    private fun convertToUSDFromEUR(amount: Double): Double {
        val exchangeRate = 0.85
        return amount * exchangeRate
    }
    private fun convertToUSDFromJPY(amount: Double): Double {
        val exchangeRate = 140.00
        return amount * exchangeRate
    }
    private fun convertToUSDFromCLP(amount: Double): Double {
        val exchangeRate = 810.00
        return amount * exchangeRate
    }


    private fun convertToEURFromUSD(amount: Double): Double {
        val exchangeRate = 1.15
        return amount * exchangeRate
    }
    private fun convertToEURFromJPY(amount: Double): Double {
        val exchangeRate = 150.00
        return amount * exchangeRate
    }
    private fun convertToEURFromEUR(amount: Double): Double {
        val exchangeRate = 1.00
        return amount * exchangeRate
    }
    private fun convertToEURFromCLP(amount: Double): Double {
        val exchangeRate = 900
        return amount * exchangeRate
    }


    private fun convertToJPYFromJPY(amount: Double): Double {
        val exchangeRate = 1
        return amount * exchangeRate
    }
    private fun convertToJPYFromUSD(amount: Double): Double {
        val exchangeRate = 0.006
        return amount * exchangeRate
    }
    private fun convertToJPYFromEUR(amount: Double): Double {
        val exchangeRate = 0.005
        return amount * exchangeRate
    }
    private fun convertToJPYFromCLP(amount: Double): Double {
        val exchangeRate = 5.78
        return amount * exchangeRate
    }


    private fun convertToCLPFromCLP(amount: Double): Double {
        val exchangeRate = 1
        return amount * exchangeRate
    }
    private fun convertToCLPFromUSD(amount: Double): Double {
        val exchangeRate = 0.001235
        return amount * exchangeRate
    }
    private fun convertToCLPFromEUR(amount: Double): Double {
        val exchangeRate = 0.001111
        return amount * exchangeRate
    }
    private fun convertToCLPFromJPY(amount: Double): Double {
        val exchangeRate = 0.17
        return amount * exchangeRate
    }

}