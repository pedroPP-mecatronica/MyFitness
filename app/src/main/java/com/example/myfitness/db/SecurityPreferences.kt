package com.example.myfitness.db
import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("FITNESS", Context.MODE_PRIVATE)

   fun storeString(key:String,value :String) {
        this.preferences.edit().putString(key, value).apply()
    }

    fun getStoreString(key: String): String {
        return this.preferences.getString(key, "") ?: ""
    }
}