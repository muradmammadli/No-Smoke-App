package com.example.nosmokeapp.activity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.nosmokeapp.ViewModel.StartViewModel
import com.example.nosmokeapp.databinding.ActivityStartBinding
import java.text.SimpleDateFormat
import java.util.*

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private lateinit var viewModel: StartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        installSplashScreen()
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickFabBtn()
        createDialog()
        viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        setDayCigar()
        setPackCigar()
        setYearCigar()
    }

    private fun createDialog() {
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }
        binding.datePickerDialog.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.datePickerText.setText(sdf.format(myCalendar.time))
    }

    private fun onClickFabBtn() {
        binding.doneFab.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun setDayCigar() {
        var dayCiga = 20
        binding.apply {
            cigaDayEditText.setText(dayCiga.toString())
            imgAdd.setOnClickListener {
                dayCiga++
//                viewModel.setNumber(dayCiga)
                cigaDayEditText.setText(dayCiga.toString())
            }
            imgRemove.setOnClickListener {
                dayCiga--
//                viewModel.setNumber(dayCiga)
                cigaDayEditText.setText(dayCiga.toString())
            }

        }

    }

    private fun setPackCigar() {
        var dayCiga = 20
        binding.apply {
            cigaPackEditText.setText(dayCiga.toString())
            imgAddPack.setOnClickListener {
                dayCiga++
//                viewModel.setNumber(dayCiga)
                cigaPackEditText.setText(dayCiga.toString())
            }
            imgRemovePack.setOnClickListener {
                dayCiga--
//                viewModel.setNumber(dayCiga)
                cigaPackEditText.setText(dayCiga.toString())
            }
        }

    }

    private fun setYearCigar() {
        var dayCiga = 1
        binding.apply {
            cigaYearEditText.setText(dayCiga.toString())
            imgAddYear.setOnClickListener {
                dayCiga++
//                viewModel.setNumber(dayCiga)
                cigaYearEditText.setText(dayCiga.toString())
            }
            imgRemoveYear.setOnClickListener {
                dayCiga--
//                viewModel.setNumber(dayCiga)
                cigaYearEditText.setText(dayCiga.toString())
            }
        }

    }
}