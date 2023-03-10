package com.example.nosmokeapp.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nosmokeapp.data.Constants.TIME_PREFERENCE
import com.example.nosmokeapp.repository.PrefRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val prefRepository: PrefRepository
) : ViewModel() {

    private var _numberCigar = MutableLiveData<Int>()
    var numberCigar: LiveData<Int> = _numberCigar

    fun setTimePref(int: Int) {
        prefRepository.setTimePreference(int)
    }

    fun setTimeStampPref(long: Long) {
        prefRepository.setTimeStampPreference(long)
    }

    fun setCigaCountPref(int: Int) {
        prefRepository.setCigaCountPreference(int)
    }

    fun setPackCigaCountPref(int: Int) {
        prefRepository.setPackCigaCountPreference(int)
    }

    fun getTime(): Int {
        return prefRepository.getTimePreference()
    }

}