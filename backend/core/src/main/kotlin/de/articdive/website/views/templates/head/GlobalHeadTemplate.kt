package de.articdive.website.views.templates.head

import de.articdive.website.session.getSettings
import io.ktor.application.ApplicationCall
import io.ktor.html.Template
import kotlinx.html.HEAD
import kotlinx.html.meta
import kotlinx.html.script

class GlobalHeadTemplate(call: ApplicationCall) : Template<HEAD> {
    private val settingsCookie = call.getSettings()

    override fun HEAD.apply() {
        // Bootstrap meta
        meta {
            charset = "UTF-8"
        }
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1.0"
        }
        script {
            src = "/frontend/webpack.js"
        }
    }
}