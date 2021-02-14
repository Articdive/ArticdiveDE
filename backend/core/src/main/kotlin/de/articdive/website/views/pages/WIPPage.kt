package de.articdive.website.views.pages

import de.articdive.website.views.templates.GlobalTemplate
import de.articdive.website.views.templates.body.GlobalNavigationTemplate
import io.ktor.application.ApplicationCall
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HTML
import kotlinx.html.h1

class WIPPage(private val call: ApplicationCall) : Template<HTML> {
    override fun HTML.apply() {
        insert(GlobalTemplate(call)) {
            htmlHead {
                headTitle {
                    text("Articdive | WIP")
                }
            }
            navigation {
                currentPage = GlobalNavigationTemplate.CurrentPage.TOOLS
            }
            content {
                h1(classes = "text-6xl") {
                    text("This page is still work in progress :)")
                }
            }
        }
    }
}