package com.example.componentes

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
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
        }
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.button_toast).setOnClickListener(this)
        findViewById<Button>(R.id.button_snack).setOnClickListener(this)
    }
}