package com.example.byjusclone.utils

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.byjusclone.R
import com.example.byjusclone.modules.DataStoreModule
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.first
import javax.inject.Inject


fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}


fun TextInputEditText.validation(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(text: Editable?) {
            afterTextChanged.invoke(text.toString())
        }
    })
}

fun isValidMobileNumber(number: String, context: Context): String? {
    if (number.isBlank()) {
        return context.getString(R.string.empty_, "Mobile Number")
    }
    if (number.length != 10) {
        return context.getString(R.string.mobile_number_length)
    }
    if (!number.matches("^[6-9][0-9]{9}$".toRegex())) {
        return context.getString(R.string.enter_valid_number)
    }
    return null
}

fun Fragment.oriantaionLandscape() {
    requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

fun Fragment.showToolbarAndClearFullScreen() {
    requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
}

fun Fragment.hideToolbarAndClearFullScreen() {
    requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
}

fun Fragment.oriantaionPortrait() {
    requireActivity()
        .requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}


fun log(tag: String, message: String) {
    Log.e(tag, message)
}

fun Fragment.toastMessage(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

suspend fun setDataInDataStore(
    context: Context,
    key: String,
    dataStoreModule: DataStoreModule,
    value: String
) {
    val dataStore = dataStoreModule.getDataStoreInstance(context)
    val dataStoreKey = stringPreferencesKey(key)
    dataStore.edit { it ->
        it[dataStoreKey] = value
    }
}

suspend fun getDataFromDataStore(
    context: Context,
    dataStoreModule: DataStoreModule,
    key: String
): String {
    val dataStore = dataStoreModule.getDataStoreInstance(context)
    val dataStoreKey = stringPreferencesKey(key)
    val preferences = dataStore.data.first()
    return preferences[dataStoreKey]!!

}


