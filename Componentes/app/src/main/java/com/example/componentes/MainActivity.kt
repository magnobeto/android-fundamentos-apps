package com.example.componentes

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

        loadSpinner()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_toast -> {
                val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.TOP, 0, 260)

                val layout = LayoutInflater.from(this).inflate(R.layout.toast_layout, null)
                toast.view = layout

                toast.show()
            }
            R.id.button_snack -> {
                val view = findViewById<LinearLayout>(R.id.linear_root)
                val snack = Snackbar.make(view, "Snack", Snackbar.LENGTH_LONG)

                snack.setAction("Desfazer", View.OnClickListener {
                    toast("Desfeito!")
                })

                snack.setActionTextColor(Color.BLUE)
                snack.setBackgroundTint(Color.GRAY)


                snack.show()
            }
            R.id.button_get_spinner -> {
                val spinner = findViewById<Spinner>(R.id.spinner_static)

                val selectItem = spinner.selectedItem
                val selectItemId = spinner.selectedItemId
                val selectItemPosition = spinner.selectedItemPosition

                toast("Position : $selectItemId: $selectItem")

            }
            R.id.button_set_spinner -> {
                val spinner = findViewById<Spinner>(R.id.spinner_static)
                spinner.setSelection(2)
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id) {
            R.id.spinner_static -> {
                toast(parent?.getItemAtPosition(position).toString())
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        toast("nothing ")
    }

    private fun loadSpinner() {
        val mList = listOf("Gramas", "Kg", "Arroba", "Tonelada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mList)
        val spinner = findViewById<Spinner>(R.id.spinner_dynamic)
        spinner.adapter = adapter
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.button_toast).setOnClickListener(this)
        findViewById<Button>(R.id.button_snack).setOnClickListener(this)
        findViewById<Button>(R.id.button_get_spinner).setOnClickListener(this)
        findViewById<Button>(R.id.button_set_spinner).setOnClickListener(this)
        findViewById<Spinner>(R.id.spinner_static).onItemSelectedListener = this
        findViewById<Spinner>(R.id.spinner_dynamic).onItemSelectedListener = this
    }
}