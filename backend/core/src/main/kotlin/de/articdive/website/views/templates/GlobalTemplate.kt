package de.articdive.website.views.templates

import de.articdive.website.session.Theme
import de.articdive.website.session.getSettings
import de.articdive.website.views.templates.body.GlobalFooterTemplate
import de.articdive.website.views.templates.body.GlobalNavigationTemplate
import de.articdive.website.views.templates.head.GlobalHeadTemplate
import de.articdive.website.views.templates.head.HeadTemplate
import io.ktor.application.ApplicationCall
import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.TemplatePlaceholder
import io.ktor.html.insert
import kotlinx.html.HTML
import kotlinx.html.MAIN
import kotlinx.html.body
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.main

class GlobalTemplate(private val call: ApplicationCall) : Template<HTML> {
    private val settingsCookie = call.getSettings()
    private val theme = settingsCookie.theme

    // Head
    private val globalHead = TemplatePlaceholder<GlobalHeadTemplate>()
    val htmlHead = TemplatePlaceholder<HeadTemplate>()

    // Body
    val navigation = TemplatePlaceholder<GlobalNavigationTemplate>()
    val content = Placeholder<MAIN>()
    private val globalFooter = TemplatePlaceholder<GlobalFooterTemplate>()

    override fun HTML.apply() {
        if (theme == Theme.DARK) {
            classes = classes + "dark"
        }
        head {
            // Insert the global head
            insert(GlobalHeadTemplate(call), globalHead)
            // Insert the subjective head, that includes the title.
            insert(HeadTemplate(), htmlHead)
        }
        body {
            div(classes = "flex flex-col min-h-screen") {
                // Header content
                header(classes = "h-16 bg-indigo-500") {
                    // Insert the Navigation Bar
                    insert(GlobalNavigationTemplate(call), navigation)
                }
                // Main content
                main(classes = "flex-grow") {
                    insert(content)
                }
                // Footer content
                footer(classes = "h-48 bg-indigo-200") {
                    insert(GlobalFooterTemplate(call), globalFooter)
                }
            }
        }
    }
}