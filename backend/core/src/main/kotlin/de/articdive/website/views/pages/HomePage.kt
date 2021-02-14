package de.articdive.website.views.pages

import de.articdive.website.views.templates.GlobalTemplate
import de.articdive.website.views.templates.body.GlobalNavigationTemplate
import io.ktor.application.ApplicationCall
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.HTML
import kotlinx.html.a
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.img
import kotlinx.html.p

class HomePage(private val call: ApplicationCall) : Template<HTML> {
    override fun HTML.apply() {
        insert(GlobalTemplate(call)) {
            htmlHead {
                headTitle {
                    text("Articdive | Home")
                }
            }
            navigation {
                currentPage = GlobalNavigationTemplate.CurrentPage.HOME
            }
            content {
                div(classes = "h-32") {
                }
                div(classes = "text-center") {
                    img(classes = "rounded-full h-32 w-32 mx-auto") {
                        src = "/static/profile.jpg"
                    }
                    h1(classes = "text-6xl") {
                        text("Welcome to my website!")
                    }
                    p {
                        br {}
                        text("I'm Lukas Mansour an Irish-German Java, Kotlin & C++ developer")
                        br {}
                        text("At the moment, I'm interested in learning Python for Machine Learning")
                        br {}
                        text("I offer my CI and Reposiory to any Java or Kotlin developers who might need it.")
                    }
                    div (classes = "space-x-32 mt-2") {
                        a(classes = "inline-block p-3 rounded border-4 border-yellow-500 text-yellow-500 text-lg font-medium hover:bg-gray-300") {
                            href = "/contact"
                            text("CONTACT ME!")
                        }
                        a(classes = "inline-block p-3 rounded border-4 border-yellow-500 text-yellow-500 text-lg font-medium hover:bg-gray-300") {
                            href = "/projects"
                            text("MY PROJECTS!")
                        }
                        a(classes = "inline-block p-3 rounded border-4 border-yellow-500 text-yellow-500 text-lg font-medium hover:bg-gray-300") {
                            href = "/about"
                            text("ABOUT ME!")
                        }
                    }
                }
            }
        }
    }
}