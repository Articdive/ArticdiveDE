package de.articdive.website.views.pages

import de.articdive.website.ccc.CSPDataInput
import de.articdive.website.views.templates.GlobalTemplate
import de.articdive.website.views.templates.body.GlobalNavigationTemplate
import io.ktor.application.ApplicationCall
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.HTML
import kotlinx.html.InputType
import kotlinx.html.br
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.p
import kotlin.math.roundToInt

class CSPPage(private val call: ApplicationCall, private val data: CSPDataInput) : Template<HTML> {
    override fun HTML.apply() {
        insert(GlobalTemplate(call)) {
            htmlHead {
                headTitle {
                    text("Articdive | CCC")
                }
            }
            navigation {
                currentPage = GlobalNavigationTemplate.CurrentPage.TOOLS
            }
            content {
                div(classes = "h-12") {
                    h1(classes = "text-center font-bold text-xl mt-3") {
                        text("CSP Cost Calculator")
                    }
                }
                div(classes = "grid grid-cols-12 gap-4") {
                    div(classes = "col-start-3 col-end-11") {
                        h1(classes = "text-center font-bold text-lg mb-1") {
                            text("Your Information")
                        }
                        form {
                            id = "cspform"
                            method = FormMethod.get
                            action = "/tools/ccc"
                            div(classes = "grid grid-cols-6 gap-4") {
                                div("col-start-1 col-end-4") {
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "userCount"
                                            text("Number of users:")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "userCount"
                                            name = "userCount"
                                            type = InputType.number
                                            value = data.userCount.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "envCount"
                                            text("Number of environments:")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "envCount"
                                            name = "envCount"
                                            type = InputType.number
                                            value = data.envCount.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "adcCount"
                                            text("Number of ADC for HDX-Proxy:")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "adcCount"
                                            name = "adcCount"
                                            type = InputType.number
                                            value = data.envCount.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "cocc"
                                            text("Cost of current Citrix on-prem license (€):")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "cocc"
                                            name = "cocc"
                                            type = InputType.text
                                            value = data.cocc.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "copl"
                                            text("Cost of Citrix Cloud (€):")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "copl"
                                            name = "copl"
                                            type = InputType.text
                                            value = data.copl.toString()
                                        }
                                    }
                                }
                                div("col-start-4 col-end-7") {
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "hpe"
                                            text("Hours per environment per month:")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "hpe"
                                            name = "hpe"
                                            type = InputType.number
                                            value = data.hpe.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "employeeValue"
                                            text("Value of employee time (€):")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "employeeValue"
                                            name = "employeeValue"
                                            type = InputType.text
                                            value = data.employeeValue.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "vmCount"
                                            text("Number of VMs per environment:")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "vmCount"
                                            name = "vmCount"
                                            type = InputType.number
                                            value = data.vmCount.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "connectorCount"
                                            text("Cloud Connectors (plus inf components):")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "connectorCount"
                                            name = "connectorCount"
                                            type = InputType.number
                                            value = data.connectorCount.toString()
                                        }
                                    }
                                    br
                                    div("h-8") {
                                        label(classes = "text-lg") {
                                            htmlFor = "tco"
                                            text("TCO per VM (€):")
                                        }
                                        input(classes = "h-8 float-right rounded border-2 border-gray-500 ml-1 mt-0.5 mb-0.5") {
                                            id = "tco"
                                            name = "tco"
                                            type = InputType.text
                                            value = data.tcoPerVm.toString()
                                        }
                                    }
                                }
                            }
                        }
                        div(classes = "grid grid-cols-12 gap-4") {
                            div(classes = "col-start-3 col-end-11 text-center") {
                                h1(classes = "font-bold text-lg mb-1 mt-2") {
                                    text("Your Savings")
                                }
                                p(classes = "text-lg") {
                                    text("Hours per month saved: ${data.hoursSaved()}")
                                }
                                p(classes = "text-lg") {
                                    text("Total # VMs Saved: ${data.vmsSaved()}")
                                }
                                p(classes = "text-lg") {
                                    text(
                                        "Total monthly savings (CSP Operational Overhead): ${
                                            data.operationalSavings().roundToInt()
                                        }€"
                                    )
                                }
                                p(classes = "text-lg") {
                                    text(
                                        "Total monthly savings (CSP Hardware): ${
                                            data.hardwareSavings().roundToInt()
                                        }€"
                                    )
                                }
                                p(classes = "text-lg") {
                                    text(
                                        "Total addl. monthly Citrix Cloud license cost: ${
                                            data.licenseCost().roundToInt()
                                        }€"
                                    )
                                }
                                p(classes = "text-xl underline font-medium") {
                                    text(
                                        "Total monthly Citrix Cloud savings: ${
                                            data.totalCloudSavings().roundToInt()
                                        }€"
                                    )
                                }
                            }
                        }
                        div("float-right mt-3") {
                            button(classes = "p-3 rounded bg-red-600 mt-1 text-white text-lg") {
                                type = ButtonType.submit
                                form = "cspform"
                                text("Calculate!")
                            }
                        }
                    }
                }
            }
        }
    }
}