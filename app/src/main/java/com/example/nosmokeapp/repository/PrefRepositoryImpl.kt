package com.example.nosmokeapp.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.nosmokeapp.data.Constants.CIGA_COUNT_PREFERENCE
import com.example.nosmokeapp.data.Constants.PACK_CIGA_COUNT_PREFERENCE
import com.example.nosmokeapp.data.Constants.PACK_PRICE_PREFERENCE
import com.example.nosmokeapp.data.Constants.TIME_PREFERENCE
import com.example.nosmokeapp.data.Constants.TIME_STAMP_PREFERENCE
import com.google.gson.Gson

class PrefRepositoryImpl(context: Context) : PrefRepository {

    private val pref: SharedPreferences =
        context.getSharedPreferences(TIME_PREFERENCE, Context.MODE_PRIVATE)
    private val editor = pref.edit()
    private val gson = Gson()

    override fun String.put(long: Long) {
        editor.putLong(this, long)
        editor.commit()
    }

    override fun String.put(int: Int) {
        editor.putInt(this, int)
        editor.commit()
    }

    override fun String.put(string: String) {
        editor.putString(this, string)
        editor.commit()
    }

    override fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.commit()
    }

    override fun String.put(double: Double) {
        editor.putLong(this, java.lang.Double.doubleToRawLongBits(double))
        editor.commit()
    }

    override fun String.getLong() = pref.getLong(this, 0)


    override fun String.getInt() = pref.getInt(this, 0)

    override fun String.getString() = pref.getString(this, "")

    override fun String.getBoolean() = pref.getBoolean(this, false)

    override fun String.getDouble(): Double {
        return java.lang.Double.longBitsToDouble(
            pref.getLong(
                this,
                java.lang.Double.doubleToRawLongBits(0.0)
            )
        )
    }


    override fun setTimeStampPreference(long: Long) {
        TIME_STAMP_PREFERENCE.put(long)
    }

    override fun setCigaCountPreference(int: Int) {
        CIGA_COUNT_PREFERENCE.put(int)
    }

    override fun setPackCigaCountPreference(int: Int) {
        PACK_CIGA_COUNT_PREFERENCE.put(int)
    }

    override fun setTimePreference(int: Int) {
        TIME_PREFERENCE.put(int)
    }

    override fun setPackPricePreference(double: Double) {
        PACK_PRICE_PREFERENCE.put(double)
    }


    override fun getTimeStampPreference(): Long {
        return TIME_STAMP_PREFERENCE.getLong()
    }

    override fun getCigaCountPreference(): Int {
        return CIGA_COUNT_PREFERENCE.getInt()
    }

    override fun getPackCigaCountPreference(): Int {
        return PACK_CIGA_COUNT_PREFERENCE.getInt()
    }

    override fun getTimePreference(): Int {
        return TIME_PREFERENCE.getInt()
    }

    override fun getPackPricePreference(): Double {
        return PACK_PRICE_PREFERENCE.getDouble()
    }


}