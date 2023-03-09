package com.example.nosmokeapp.activity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.nosmokeapp.ViewModel.StartViewModel
import com.example.nosmokeapp.databinding.ActivityStartBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
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
        Log.d("dddddd", "${viewModel.getTime()}")
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
        viewModel.setCigaCountPref(dayCiga)
        binding.apply {
            cigaDayEditText.setText(dayCiga.toString())
            imgAdd.setOnClickListener {
                dayCiga++
                viewModel.setCigaCountPref(dayCiga)
                cigaDayEditText.setText(dayCiga.toString())
            }
            imgRemove.setOnClickListener {
                dayCiga--
                viewModel.setCigaCountPref(dayCiga)
                cigaDayEditText.setText(dayCiga.toString())
            }
        }

    }

    private fun setPackCigar() {
        var packCiga = 20
        viewModel.setPackCigaCountPref(packCiga)
        binding.apply {
            cigaPackEditText.setText(packCiga.toString())
            imgAddPack.setOnClickListener {
                packCiga++
                viewModel.setPackCigaCountPref(packCiga)
                cigaPackEditText.setText(packCiga.toString())
            }
            imgRemovePack.setOnClickListener {
                packCiga--
                viewModel.setPackCigaCountPref(packCiga)
                cigaPackEditText.setText(packCiga.toString())
            }
        }

    }

    private fun setYearCigar() {
        var yearCiga = 1
        viewModel.setTimePref(yearCiga)
        binding.apply {
            cigaYearEditText.setText(yearCiga.toString())
            imgAddYear.setOnClickListener {
                yearCiga++
                viewModel.setTimePref(yearCiga)
                cigaYearEditText.setText(yearCiga.toString())
            }
            imgRemoveYear.setOnClickListener {
                yearCiga--
                viewModel.setTimePref(yearCiga)
                cigaYearEditText.setText(yearCiga.toString())
            }
        }

    }
}