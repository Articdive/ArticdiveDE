package de.articdive.website.session

import io.ktor.application.ApplicationCall
import io.ktor.sessions.getOrSet
import io.ktor.sessions.sessions
import java.util.*

data class SettingsCookie(val locale: Locale, val theme : Theme)

enum class Theme {
    DARK,
    LIGHT
}

fun ApplicationCall.getSettings(): SettingsCookie {
    return sessions.getOrSet {
        SettingsCookie(Locale("en"), Theme.LIGHT)
    }
}


