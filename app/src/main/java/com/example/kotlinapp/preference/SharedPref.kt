package com.example.kotlinapp.preference

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences


object SharedPref {



    private var mSharedPref: SharedPreferences? = null
    fun init(context: Context) {
        if (mSharedPref == null) mSharedPref = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
//        val masterKeys = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
//        val mSharedPref = EncryptedSharedPreferences.create(
//            "shared_preferences_filename",
//            masterKeys,
//            context,
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )
    }

    fun write(key: String?, value: String?) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    fun read(key: String?, defValue: String?): String? {
        return mSharedPref!!.getString(key, defValue)
    }

    fun write(key: String?, value: Boolean) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.commit()
        prefsEditor.clear()
    }


    fun read(key: String?, defValue: Boolean): Boolean {
        return mSharedPref!!.getBoolean(key, defValue)
    }

    fun write(key: String?, value: Int?) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putInt(key, value!!).commit()
    }


    fun read(key: String?, defValue: Int): Int {
        return mSharedPref!!.getInt(key, defValue)
    }


}