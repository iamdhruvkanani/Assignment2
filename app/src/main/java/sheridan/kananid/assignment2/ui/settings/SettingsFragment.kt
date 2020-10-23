package sheridan.kananid.assignment2.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import sheridan.kananid.assignment2.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}