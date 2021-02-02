package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonViewCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.button_view_calculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOk()) {
            try {
                val distance = binding.textViewEditDistance.text.toString().toFloat()
                val price = binding.textViewEditPrice.text.toString().toFloat()
                val autonomy = binding.textViewEditAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                binding.textViewTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_os_campos), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validationOk(): Boolean = (binding.textViewEditDistance.text.toString() != "" &&
            binding.textViewEditPrice.text.toString() != "" &&
            binding.textViewEditAutonomy.text.toString() != "")
}