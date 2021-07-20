package com.example.componentes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class TimeActivity :
    AppCompatActivity(),
    View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    private val mSimpleDate = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        setListeners()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_date -> {

                val calendar = Calendar.getInstance()
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH)
                val year = calendar.get(Calendar.YEAR)

                DatePickerDialog(this, this, year, month, day).show()
            }
        }
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val buttonDate = findViewById<Button>(R.id.button_date)
        val date = Calendar.getInstance()

        date.set(year, month, dayOfMonth)
        buttonDate.text = mSimpleDate.format(date.time)
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.button_date).setOnClickListener(this)
    }
}