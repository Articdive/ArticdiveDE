package de.articdive.website.views.templates.body

import de.articdive.website.session.getSettings
import io.ktor.application.ApplicationCall
import io.ktor.html.Template
import kotlinx.html.FOOTER
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.img
import kotlinx.html.unsafe


class GlobalFooterTemplate(call: ApplicationCall) : Template<FOOTER> {
    private val application = call.application
    private val settingsCookie = call.getSettings()
    private val locale = settingsCookie.locale

    override fun FOOTER.apply() {
        div(classes = "h-40 grid grid-cols-8 gap-8 border-t-2 border-indigo-400") {
            div(classes = "col-start-2 col-end-4") {
                h1(classes = "block text-lg underline") {
                    text("Settings")
                }
            }
            div(classes = "col-start-4 col-end-6") {
                h1(classes = "block text-lg underline") {
                    text("Social Media")
                }
                div (classes = "space-x-2") {
                    a(classes = "inline-block") {
                        href = "https://github.com/Articdive"
                        img {
                            width = "30"
                            height = "30"
                            src = "/icons/github.svg"
                        }
                    }
                    a(classes = "inline-block") {
                        href = "https://www.linkedin.com/in/lukas-mansour/"
                        img {
                            width = "30"
                            height = "30"
                            src = "/icons/linkedin.svg"
                        }
                    }
                    a(classes = "inline-block") {
                        href = "https://steamcommunity.com/id/Articdive"
                        img {
                            width = "30"
                            height = "30"
                            src = "/icons/steam.svg"
                        }
                    }
                    a(classes = "inline-block") {
                        href = "https://twitter.com/Articdive"
                        img {
                            width = "30"
                            height = "30"
                            src = "/icons/twitter.svg"
                        }
                    }
                }
            }
            div(classes = "col-start-6 col-end-8") {
                div(classes = "font-normal text-base text-black") {
                    h1(classes = "block text-lg underline") {
                        text("Utilities")
                    }
                    a(classes = "block hover:underline") {
                        href = "https://repo.minestom.com"
                        text("Maven Repository")
                        unsafe {
                            raw(
                                """<svg xmlns="http://www.w3.org/2000/svg" height="20" width="20" fill="currentColor" class="inline">
  <path d="M11 3a1 1 0 100 2h2.586l-6.293 6.293a1 1 0 101.414 1.414L15 6.414V9a1 1 0 102 0V4a1 1 0 00-1-1h-5z" />
  <path d="M5 5a2 2 0 00-2 2v8a2 2 0 002 2h8a2 2 0 002-2v-3a1 1 0 10-2 0v3H5V7h3a1 1 0 000-2H5z" />
</svg>"""
                            )
                        }
                    }
                    a(classes = "block hover:underline") {
                        href = "https://ci.minestom.com"
                        text("Continious Integration")
                        unsafe {
                            raw(
                                """<svg xmlns="http://www.w3.org/2000/svg" height="20" width="20" fill="currentColor" class="inline">
  <path d="M11 3a1 1 0 100 2h2.586l-6.293 6.293a1 1 0 101.414 1.414L15 6.414V9a1 1 0 102 0V4a1 1 0 00-1-1h-5z" />
  <path d="M5 5a2 2 0 00-2 2v8a2 2 0 002 2h8a2 2 0 002-2v-3a1 1 0 10-2 0v3H5V7h3a1 1 0 000-2H5z" />
</svg>"""
                            )
                        }
                    }
                }
            }
        }
        div(classes = "h-8 border-t-2 border-indigo-400 text-center text-lg") {
            h1 {
                text("© 2021 Copyright: Lukas Mansour (Pseudonym: Articdive)")
            }
        }
    }
}