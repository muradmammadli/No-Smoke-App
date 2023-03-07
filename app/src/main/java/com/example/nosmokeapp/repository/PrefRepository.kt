package com.example.nosmokeapp.repository

interface PrefRepository {

    fun String.put(long: Long)
    fun String.put(int: Int)
    fun String.put(string: String)
    fun String.put(boolean: Boolean)

    fun String.getLong()
    fun String.getInt()
    fun String.getString()
    fun String.getBoolean()
}