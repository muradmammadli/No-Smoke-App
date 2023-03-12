package com.example.nosmokeapp.repository

import android.content.SharedPreferences

interface PrefRepository {

    fun String.put(long: Long)
    fun String.put(int: Int)
    fun String.put(string: String)
    fun String.put(boolean: Boolean)
    fun String.put(double: Double)

    fun String.getLong(): Long
    fun String.getInt(): Int
    fun String.getString(): String?
    fun String.getBoolean(): Boolean
    fun String.getDouble():Double

    fun setTimeStampPreference(long: Long)
    fun setCigaCountPreference(int: Int)
    fun setPackCigaCountPreference(int: Int)
    fun setTimePreference(int: Int)
    fun setPackPricePreference(double: Double)


    fun getTimeStampPreference():Long
    fun getCigaCountPreference():Int
    fun getPackCigaCountPreference():Int
    fun getTimePreference():Int
    fun getPackPricePreference(): Double

}
