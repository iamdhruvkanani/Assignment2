package sheridan.kananid.assignment2.ui.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import sheridan.kananid.assignment2.R

class RollerSettings(private val context: Context){

    private val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)



    val confirmDelete: Boolean
        get() = preferences.getBoolean("confirm_delete", true)

    val confirmClear: Boolean
        get() = preferences.getBoolean("confirm_clear", true)
}