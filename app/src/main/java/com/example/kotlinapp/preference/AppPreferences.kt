//package com.example.kotlinapp
//
//import android.content.Context
//import android.content.SharedPreferences
//
//object AppPreferences {
//
//
//    private const val NAME = "myPref"
//    private const val MODE = Context.MODE_PRIVATE
//    private lateinit var preferences: SharedPreferences
//
////SharedPreference  variable
//
//    private val IS_LOGIN = Pair("is_Login", false)
//    private val USERNAME = Pair("username", "raj")
//    private val PASSWORD = Pair("password", "12345")
//
//    fun init(context: Context) {
//        preferences = context.getSharedPreferences(NAME, MODE)
//    }
//
////inline function to put a variable and save it
//    /**'
//     * we used one inline function SharedPreferences.
//     * edit that will create the SharedPreferences.Editor object and then save the variable by apply().
//     */
//
//    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
//        val editor = edit()
//        operation(editor)
//        editor.apply()
//
//    }
//
////SharedPreferences variables getters/setters
//
//    var isLogin: Boolean
//        get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
//        set(value) = preferences.edit {
//            it.putBoolean(IS_LOGIN.first, value)
//        }
//    var username: String
//        get() = preferences.getString(USERNAME.first, USERNAME.second) ?: ""
//        set(value) = preferences.edit {
//            it.putString(USERNAME.first, value)
//        }
//
//    var password: String
//        get() = preferences.getString(PASSWORD.first, PASSWORD.second) ?: ""
//        set(value) = preferences.edit {
//            it.putString(PASSWORD.first, value)
//
//        }
//}