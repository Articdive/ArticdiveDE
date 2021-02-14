package de.articdive.website

import de.articdive.website.ccc.CSPDataInput
import de.articdive.website.exceptions.AuthorizationException
import de.articdive.website.session.SettingsCookie
import de.articdive.website.session.Theme
import de.articdive.website.session.getSettings
import de.articdive.website.views.pages.CSPPage
import de.articdive.website.views.pages.HomePage
import de.articdive.website.views.pages.WIPPage
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.html.respondHtmlTemplate
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.sessions.SessionSerializer
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import io.ktor.util.KtorExperimentalAPI
import java.util.*
import javax.naming.AuthenticationException

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(Sessions) {
        cookie<SettingsCookie>("settings_cookie") {
            serializer = object : SessionSerializer<SettingsCookie> {
                override fun serialize(session: SettingsCookie): String {
                    val locale = session.locale.toLanguageTag()
                    val darkMode = session.theme.name
                    return "$locale,$darkMode"
                }

                override fun deserialize(text: String): SettingsCookie {
                    val arr = text.split(',')
                    val locale = Locale(arr[0])
                    val theme = Theme.valueOf(arr[1].toUpperCase())
                    return SettingsCookie(locale, theme)
                }
            }
        }
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    install(StatusPages) {
        exception<AuthenticationException> {
            call.respond(HttpStatusCode.Unauthorized)
        }
        exception<AuthorizationException> {
            call.respond(HttpStatusCode.Forbidden)
        }
    }

    routing {
        static("frontend") {
            resources("frontend")
        }
        static("icons") {
            resources("icons")
        }
        static("static") {
            resources("static")
        }
        get("/") {
            call.getSettings()
            call.respondHtmlTemplate(HomePage(call), HttpStatusCode.OK) {}
        }
        get("/contact") {
            call.getSettings()
            call.respondHtmlTemplate(WIPPage(call), HttpStatusCode.OK) {}
        }
        get("/about") {
            call.getSettings()
            call.respondHtmlTemplate(WIPPage(call), HttpStatusCode.OK) {}
        }
        get("/projects") {
            call.getSettings()
            call.respondHtmlTemplate(WIPPage(call), HttpStatusCode.OK) {}
        }
        get("/tools/rcg") {
            call.getSettings()
            call.respondHtmlTemplate(WIPPage(call), HttpStatusCode.OK) {}
        }
        get("/tools/ccc") {
            call.getSettings()
            val params = call.request.queryParameters

            val userCount = params["userCount"]?.toInt() ?: 0
            val envCount = params["envCount"]?.toInt() ?: 0
            val adcCount = params["adcCount"]?.toInt() ?: 0
            val copl = params["copl"]?.toDouble() ?: 0.00
            val cocc = params["cocc"]?.toDouble() ?: 0.00

            val hpe = params["hpe"]?.toInt() ?: 0
            val employeeValue = params["employeeValue"]?.toDouble() ?: 0.00

            val vmCount = params["vmCount"]?.toInt() ?: 0
            val connectorCount = params["connectorCount"]?.toInt() ?: 0
            val tco = params["tco"]?.toDouble() ?: 0.00

            val cspDataInput = CSPDataInput(
                userCount,
                envCount,
                adcCount,
                copl,
                cocc,
                hpe,
                employeeValue,
                vmCount,
                connectorCount,
                tco
            )

            call.respondHtmlTemplate(CSPPage(call, cspDataInput), HttpStatusCode.OK) {}
        }
    }
}

// Environment System
@OptIn(KtorExperimentalAPI::class)
val Application.envKind
    get() = environment.config.property("ktor.environment").getString()
val Application.isDev get() = envKind == "dev"
val Application.isProd get() = envKind == "prod"

// Locales
// Get supported Locales.
@OptIn(KtorExperimentalAPI::class)
val Application.supportedLocales
    get() = environment.config.property("ktor.supportedLocales").getList().map { Locale(it) }
