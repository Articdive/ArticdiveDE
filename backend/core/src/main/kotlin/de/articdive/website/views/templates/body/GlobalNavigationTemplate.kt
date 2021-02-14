package de.articdive.website.views.templates.body

import de.articdive.website.session.getSettings
import io.ktor.application.ApplicationCall
import io.ktor.html.Template
import kotlinx.html.HEADER
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.nav
import kotlinx.html.unsafe

class GlobalNavigationTemplate(call: ApplicationCall) : Template<HEADER> {
    private val settingsCookie = call.getSettings()
    private val locale = settingsCookie.locale
    var currentPage = CurrentPage.HOME

    override fun HEADER.apply() {
        nav {
            div(classes = "flex space-x-4") {
                val activeElement = setOf(
                    "bg-indigo-700"
                )
                val unactiveElement = setOf(
                    "hover:bg-indigo-600",
                    "hover:border-solid",
                    "hover:border-b-2",
                    "hover:border-red-400"
                )

                a(classes = "p-4 text-lg text-white font-medium") {
                    href = "https://www.articdive.de"

                    text("Articdive")
                }
                a(classes = "mx-2 my-4 px-2 text-base text-white font-normal rounded") {
                    if (currentPage == CurrentPage.HOME) {
                        classes = classes + activeElement
                    } else {
                        classes = classes + unactiveElement
                    }
                    href = "/"
                    text("Home")
                }
                div {
                    button(classes = "group mx-2 my-4 px-2 text-base text-white font-normal rounded") {
                        if (currentPage == CurrentPage.TOOLS) {
                            classes = classes + unactiveElement - "hover:bg-indigo-600" + activeElement
                        } else {
                            classes = classes + unactiveElement
                        }
                        text("Tools")
                        unsafe {
                            raw(
                                """<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" height="20" width="20" class="inline">
  <path fill-rule="evenodd" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd" />
</svg>"""
                            )
                        }
                        div(
                            classes =
                            "hidden absolute rounded bg-white font-normal text-black " +
                                    "mt-0.5 border-solid border-2 border-indigo-300 group-hover:block group-focus:block"
                        ) {
                            a(classes = "px-3 py-2 block hover:bg-gray-300") {
                                href = "/tools/rcg"
                                text("Random Colour Generator")
                            }
                            a(classes = "px-3 py-2 block hover:bg-gray-300") {
                                href = "/tools/ccc"
                                text("CSP Cost Calculator")
                            }
                        }
                    }
                }
                a(classes = "mx-2 my-4 px-2 text-base text-white font-normal rounded") {
                    if (currentPage == CurrentPage.PROJECTS) {
                        classes = classes + activeElement
                    } else {
                        classes = classes + unactiveElement
                    }
                    href = "/projects"
                    text("Projects")
                }
                a(classes = "mx-2 my-4 px-2 text-base text-white font-normal rounded") {
                    if (currentPage == CurrentPage.ABOUT) {
                        classes = classes + activeElement
                    } else {
                        classes = classes + unactiveElement
                    }
                    href = "/about"
                    text("About Me")
                }
                a(classes = "mx-2 my-4 px-2 text-base text-white font-normal rounded") {
                    if (currentPage == CurrentPage.CONTACT) {
                        classes = classes + activeElement
                    } else {
                        classes = classes + unactiveElement
                    }
                    href = "/contact"
                    text("Contact")
                }
            }
        }
    }

    enum class CurrentPage {
        HOME,
        TOOLS,
        PROJECTS,
        ABOUT,
        CONTACT
    }
}