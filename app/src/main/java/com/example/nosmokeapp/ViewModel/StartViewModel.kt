package com.example.nosmokeapp.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {

    private var _numberCigar = MutableLiveData<Int>()
    var numberCigar: LiveData<Int> = _numberCigar

    fun setNumber(int:Int) {
        _numberCigar.value = int
        Log.d("NumberCigar", "${numberCigar.value}")
    }



}