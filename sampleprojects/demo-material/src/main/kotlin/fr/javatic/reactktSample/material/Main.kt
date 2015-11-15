package fr.javatic.reactktSample.material

import fr.javatic.reactkt.core.ReactDOM
import fr.javatic.reactkt.core.ktx
import kotlin.browser.document

fun main(args: Array<String>) {
    ReactDOM.render(ktx { component(::App) }, document.getElementById("app")!!)
}