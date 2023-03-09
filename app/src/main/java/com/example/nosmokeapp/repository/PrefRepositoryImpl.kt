package com.example.nosmokeapp.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.nosmokeapp.data.Constants.CIGA_COUNT_PREFERENCE
import com.example.nosmokeapp.data.Constants.PACK_CIGA_COUNT_PREFERENCE
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

    override fun String.getLong() = pref.getLong(this, 0)


    override fun String.getInt() = pref.getInt(this, 0)

    override fun String.getString() = pref.getString(this, "")

    override fun String.getBoolean() = pref.getBoolean(this, false)


    override fun setTimeStampPreference(int: Int) {
        TIME_STAMP_PREFERENCE.put(int)
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


    override fun getTimeStampPreference(): Int {
       return TIME_STAMP_PREFERENCE.getInt()
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


}