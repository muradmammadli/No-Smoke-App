package com.example.nosmokeapp.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.nosmokeapp.data.Constants.TIME_PREFERENCE
import com.google.gson.Gson

class PrefRepositoryImpl(context: Context) : PrefRepository {

    private val pref:SharedPreferences = context.getSharedPreferences(TIME_PREFERENCE,Context.MODE_PRIVATE)
    private val editor = pref.edit()
    private val gson = Gson()

    override fun String.put(long: Long) {
        TODO("Not yet implemented")
    }

    override fun String.put(int: Int) {
        TODO("Not yet implemented")
    }

    override fun String.put(string: String) {
        TODO("Not yet implemented")
    }

    override fun String.put(boolean: Boolean) {
        TODO("Not yet implemented")
    }

    override fun String.getLong() {
        TODO("Not yet implemented")
    }

    override fun String.getInt() {
        TODO("Not yet implemented")
    }

    override fun String.getString() {
        TODO("Not yet implemented")
    }

    override fun String.getBoolean() {
        TODO("Not yet implemented")
    }


}