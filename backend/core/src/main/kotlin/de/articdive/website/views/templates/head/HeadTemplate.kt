package de.articdive.website.views.templates.head

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HEAD
import kotlinx.html.TITLE
import kotlinx.html.title

class HeadTemplate : Template<HEAD> {
    val headTitle = Placeholder<TITLE>()
    val customHeadTags = Placeholder<HEAD>()

    override fun HEAD.apply() {
        title {
            insert(headTitle)
        }
        // Custom head tags (custom fonts, scripts etc.)
        insert(customHeadTags)
    }
}