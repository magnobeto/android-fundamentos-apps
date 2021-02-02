package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.R
import com.example.motivation.databinding.ActivitySplashBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.splashViewButtonSave.setOnClickListener(this)
        verifyName()
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.splash_view_button_save) {
            handleSave()
        }
    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != "") {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.splashViewTxtEditName.text.toString()

        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME,name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Informe seu Nome", Toast.LENGTH_SHORT).show()
        }
    }
}