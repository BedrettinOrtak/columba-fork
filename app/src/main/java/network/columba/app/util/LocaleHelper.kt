package network.columba.app.util

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import java.util.Locale

/**
 * Helper for per-app language switching.
 * Language is stored synchronously in SharedPreferences so it can be read in
 * Activity/Application.attachBaseContext() before Hilt or DataStore are ready.
 */
object LocaleHelper {
    const val PREFS_NAME = "language_prefs"
    const val PREF_LANGUAGE = "app_language"
    const val PREF_LANGUAGE_SELECTION_COMPLETED = "language_selection_completed"

    /** Call from Activity.attachBaseContext to wrap the base context with the stored locale. */
    fun onAttach(context: Context): Context {
        val language = getLanguage(context)
        return if (language.isEmpty()) context else applyLocale(context, language)
    }

    /** Read the stored language tag synchronously (e.g. "tr", "fa", "ku", "en", or "" for system). */
    fun getLanguage(context: Context): String =
        getPrefs(context).getString(PREF_LANGUAGE, "") ?: ""

    /** Persist the language tag and return a context with the new locale applied. */
    fun setLocale(context: Context, language: String): Context {
        saveLanguage(context, language)
        return if (language.isEmpty()) context else applyLocale(context, language)
    }

    /** Persist the language tag without applying it (call recreate() after this). */
    fun saveLanguage(context: Context, language: String) {
        getPrefs(context).edit().putString(PREF_LANGUAGE, language).apply()
    }

    /** Whether the first-launch language selector has been completed. */
    fun isLanguageSelectionCompleted(context: Context): Boolean =
        getPrefs(context).getBoolean(PREF_LANGUAGE_SELECTION_COMPLETED, false)

    /** Mark first-launch language selection as completed. */
    fun setLanguageSelectionCompleted(
        context: Context,
        completed: Boolean,
    ) {
        getPrefs(context).edit().putBoolean(PREF_LANGUAGE_SELECTION_COMPLETED, completed).apply()
    }

    private fun getPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private fun applyLocale(context: Context, language: String): Context {
        val locale = Locale.forLanguageTag(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocales(LocaleList(locale))
        } else {
            @Suppress("DEPRECATION")
            config.locale = locale
        }
        return context.createConfigurationContext(config)
    }
}

