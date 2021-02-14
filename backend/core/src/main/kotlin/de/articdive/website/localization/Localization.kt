package de.articdive.website.localization

import java.util.*

fun t(key: String, locale: Locale, vararg arguments: Any?): String {
    return ResourceBundle.getBundle("localization.messages", locale).getString(key).format(arguments)
}