package com.example.componentes

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class TimeActivity :
    AppCompatActivity(),
    View.OnClickListener,
    DatePickerDialog.OnDateSetListener,
    TimePicker.OnTimeChangedListener {

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
            R.id.button_get_time -> {
                val timePicker = findViewById<TimePicker>(R.id.timepicker)

                if (Build.VERSION.SDK_INT >= 23) {
                    val hour = timePicker.hour
                    val minute = timePicker.minute

                    toast("$hour:$minute")
                } else {
                    val hour = timePicker.currentHour
                    val minute = timePicker.currentMinute

                    toast("$hour:$minute")
                }
            }
            R.id.button_set_time -> {
                val timePicker = findViewById<TimePicker>(R.id.timepicker)

                if (Build.VERSION.SDK_INT >= 23) {
                    timePicker.hour = 20
                    timePicker.minute = 20
                } else {
                    timePicker.currentHour = 20
                    timePicker.currentMinute = 20
                }
            }
        }
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val buttonDate = findViewById<Button>(R.id.button_date)
        val date = Calendar.getInstance()

        date.set(year, month, dayOfMonth)
        buttonDate.text = mSimpleDate.format(date.time)
    }

    override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
        toast("$hourOfDay:$minute")
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.button_date).setOnClickListener(this)
        findViewById<TimePicker>(R.id.timepicker).setOnTimeChangedListener(this)
        findViewById<Button>(R.id.button_get_time).setOnClickListener(this)
        findViewById<Button>(R.id.button_set_time).setOnClickListener(this)
    }
}