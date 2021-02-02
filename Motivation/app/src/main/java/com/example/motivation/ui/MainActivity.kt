package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mphraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        
        setListeners()
        showUserName()

        //disparo inicial
        binding.mainActivityImageAll.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.purple_200
            )
        )
        handleNewPhrase()
    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(
            R.id.main_activity_image_all,
            R.id.main_activity_image_happy,
            R.id.main_activity_image_morning
        )

        if (id == R.id.main_activity_button) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun setListeners() {
        binding.mainActivityButton.setOnClickListener(this)
        binding.mainActivityImageAll.setOnClickListener(this)
        binding.mainActivityImageHappy.setOnClickListener(this)
        binding.mainActivityImageMorning.setOnClickListener(this)
    }

    private fun showUserName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.mainActivityTextName.text = "Olá, $name!"
    }

    private fun handleFilter(id: Int) {

        binding.mainActivityImageAll.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )

        binding.mainActivityImageHappy.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )

        binding.mainActivityImageMorning.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )

        when (id) {
            R.id.main_activity_image_all -> {
                binding.mainActivityImageAll.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_200
                    )
                )
                mphraseFilter = MotivationConstants.PHRASEFILTER.ALL

            }
            R.id.main_activity_image_happy -> {
                binding.mainActivityImageHappy.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_200
                    )
                )
                mphraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.main_activity_image_morning -> {
                binding.mainActivityImageMorning.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_200
                    )
                )
                mphraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }

    }

    private fun handleNewPhrase() {
        binding.mainActivityTextPhrase.text = Mock().getPhrase(mphraseFilter)
    }
}