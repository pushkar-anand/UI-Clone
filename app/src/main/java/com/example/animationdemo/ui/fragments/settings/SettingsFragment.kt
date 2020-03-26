package com.example.animationdemo.ui.fragments.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.view.ContextThemeWrapper
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.example.animationdemo.R
import com.example.animationdemo.utils.NightMode
import java.util.*


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        val contextThemeWrapper: Context =
            ContextThemeWrapper(activity, R.style.AppTheme_ActionBar)

        // clone the inflater using the ContextThemeWrapper

        // clone the inflater using the ContextThemeWrapper
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        return super.onCreateView(localInflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val themePref = findPreference<ListPreference>(getString(R.string.pref_key_night))
        themePref?.setOnPreferenceChangeListener { _, newValue ->
            val selectedTheme = newValue as String
            val mode = NightMode.valueOf(selectedTheme.toUpperCase(Locale.US))
            updateTheme(mode.value)
            true
        }

    }

    private fun updateTheme(nightMode: Int): Boolean {
        AppCompatDelegate.setDefaultNightMode(nightMode)
        requireActivity().recreate()
        return true
    }
}

