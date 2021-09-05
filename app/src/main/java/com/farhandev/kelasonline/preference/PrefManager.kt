package com.farhandev.kelasonline.preference

import android.content.Context
import android.content.SharedPreferences

class PrefManager (context: Context) {
    private val prefName = "KelasOnline1234.pref"
    private var sharedPref: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key:String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun put(key: String, value: Int){
        editor.putInt(key,value)
            .apply()
    }

    fun getString(key: String): String? {
        return sharedPref.getString(key,"")
    }

    fun getInt(key: String): Int {
        return sharedPref.getInt(key,0)
    }

    fun clear(){
        editor.clear()
            .apply()
    }
}