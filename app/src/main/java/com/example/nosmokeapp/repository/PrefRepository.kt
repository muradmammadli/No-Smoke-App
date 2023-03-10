package com.example.nosmokeapp.repository

interface PrefRepository {

    fun String.put(long: Long)
    fun String.put(int: Int)
    fun String.put(string: String)
    fun String.put(boolean: Boolean)

    fun String.getLong(): Long
    fun String.getInt(): Int
    fun String.getString(): String?
    fun String.getBoolean(): Boolean

    fun setTimeStampPreference(long: Long)
    fun setCigaCountPreference(int: Int)
    fun setPackCigaCountPreference(int: Int)
    fun setTimePreference(int: Int)


    fun getTimeStampPreference():Long
    fun getCigaCountPreference():Int
    fun getPackCigaCountPreference():Int
    fun getTimePreference():Int
}
