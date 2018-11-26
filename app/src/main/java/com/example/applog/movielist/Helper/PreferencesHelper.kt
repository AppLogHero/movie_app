package com.example.applog.movielist.Helper

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper(private val context: Context) {

    companion object {
        val DEVELOP_MODE = false
        private const val FAKE_CONST= "com.fake.cont.YEAH"

    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    var fakeConst = preferences.getString(FAKE_CONST, "")
    set(value) = preferences.edit().putString(FAKE_CONST, value).apply()

}