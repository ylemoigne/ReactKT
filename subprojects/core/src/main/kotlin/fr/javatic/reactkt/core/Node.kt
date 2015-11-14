/*
 * Copyright 2015 Yann Le Moigne
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.javatic.reactkt.core

import fr.javatic.reactkt.core.binding.InternalReact
import fr.javatic.reactkt.core.binding.toJsObject
import kotlin.Pair

class Node {
    val children = arrayListOf<ReactElement>()

    private fun uglyHackForString(value: dynamic): ReactElement {
        return value
    }

    operator fun String?.unaryPlus() {
        if (this != null) {
            children.add(uglyHackForString(this))
        }
    }

    operator fun ReactElement?.unaryPlus() {
        if (this != null) {
            children.add(this)
        }
    }

    operator fun Iterable<ReactElement>.unaryPlus() {
        children.addAll(this)
    }

    fun <P> component(f: () -> Component<P, *>, props: P? = null, init: (Node.() -> Unit)? = null): Node {
        val el = Node()
        if (init != null) {
            el.init()
        }
        children.add(InternalReact.createElement(f, props, *el.children.toTypedArray()))
        return el
    }

    fun <P> component(f: (P) -> Component<P, *>, props: P? = null, init: (Node.() -> Unit)? = null): Node {
        val el = Node()
        if (init != null) {
            el.init()
        }
        children.add(InternalReact.createElement(f, props, *el.children.toTypedArray()))
        return el
    }

    fun tag(name: String, attributes: Array<out Pair<String, Any?>>,
            init: (Node.() -> Unit)? = null): Node {
        val el = Node()
        if (init != null) {
            el.init()
        }
        children.add(InternalReact.createElement(name, attributes.toArrayList().toJsObject(), *el.children.toTypedArray()))
        return el
    }

    fun a(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("a", attributes, init)
    fun abbr(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("abbr", attributes, init)
    fun address(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("address", attributes, init)
    fun area(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("area", attributes, init)
    fun article(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("article", attributes, init)
    fun aside(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("aside", attributes, init)
    fun audio(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("audio", attributes, init)
    fun b(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("b", attributes, init)
    fun base(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("base", attributes, init)
    fun bdi(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("bdi", attributes, init)
    fun bdo(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("bdo", attributes, init)
    fun big(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("big", attributes, init)
    fun blockquote(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("blockquote", attributes, init)
    fun body(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("body", attributes, init)
    fun br(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("br", attributes, init)
    fun button(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("button", attributes, init)
    fun canvas(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("canvas", attributes, init)
    fun caption(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("caption", attributes, init)
    fun cite(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("cite", attributes, init)
    fun code(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("code", attributes, init)
    fun col(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("col", attributes, init)
    fun colgroup(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("colgroup", attributes, init)
    fun data(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("data", attributes, init)
    fun datalist(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("datalist", attributes, init)
    fun dd(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("dd", attributes, init)
    fun del(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("del", attributes, init)
    fun details(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("details", attributes, init)
    fun dfn(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("dfn", attributes, init)
    fun dialog(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("dialog", attributes, init)
    fun div(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("div", attributes, init)
    fun dl(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("dl", attributes, init)
    fun dt(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("dt", attributes, init)
    fun em(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("em", attributes, init)
    fun embed(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("embed", attributes, init)
    fun fieldset(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("fieldset", attributes, init)
    fun figcaption(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("figcaption", attributes, init)
    fun figure(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("figure", attributes, init)
    fun footer(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("footer", attributes, init)
    fun form(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("form", attributes, init)
    fun h1(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("h1", attributes, init)
    fun h2(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("h2", attributes, init)
    fun h3(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("h3", attributes, init)
    fun h4(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("h4", attributes, init)
    fun h5(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("h5", attributes, init)
    fun h6(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("h6", attributes, init)
    fun head(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("head", attributes, init)
    fun header(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("header", attributes, init)
    fun hgroup(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("hgroup", attributes, init)
    fun hr(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("hr", attributes, init)
    fun html(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("html", attributes, init)
    fun i(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("i", attributes, init)
    fun iframe(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("iframe", attributes, init)
    fun img(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("img", attributes, init)
    fun input(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("input", attributes, init)
    fun ins(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("ins", attributes, init)
    fun kbd(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("kbd", attributes, init)
    fun keygen(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("keygen", attributes, init)
    fun label(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("label", attributes, init)
    fun legend(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("legend", attributes, init)
    fun li(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("li", attributes, init)
    fun link(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("link", attributes, init)
    fun main(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("main", attributes, init)
    fun map(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("map", attributes, init)
    fun mark(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("mark", attributes, init)
    fun menu(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("menu", attributes, init)
    fun menuitem(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("menuitem", attributes, init)
    fun meta(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("meta", attributes, init)
    fun meter(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("meter", attributes, init)
    fun nav(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("nav", attributes, init)
    fun noscript(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("noscript", attributes, init)
    //    fun `object`(vararg attributes:Pair<String,Any>, init: Node.()->Unit):Node = tag("`object`", attributes, init)
    fun ol(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("ol", attributes, init)

    fun optgroup(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("optgroup", attributes, init)
    fun option(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("option", attributes, init)
    fun output(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("output", attributes, init)
    fun p(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("p", attributes, init)
    fun param(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("param", attributes, init)
    fun picture(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("picture", attributes, init)
    fun pre(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("pre", attributes, init)
    fun progress(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("progress", attributes, init)
    fun q(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("q", attributes, init)
    fun rp(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("rp", attributes, init)
    fun rt(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("rt", attributes, init)
    fun ruby(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("ruby", attributes, init)
    fun s(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("s", attributes, init)
    fun samp(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("samp", attributes, init)
    fun script(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("script", attributes, init)
    fun section(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("section", attributes, init)
    fun select(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("select", attributes, init)
    fun small(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("small", attributes, init)
    fun source(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("source", attributes, init)
    fun span(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("span", attributes, init)
    fun strong(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("strong", attributes, init)
    fun style(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("style", attributes, init)
    fun sub(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("sub", attributes, init)
    fun summary(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("summary", attributes, init)
    fun sup(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("sup", attributes, init)
    fun table(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("table", attributes, init)
    fun tbody(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("tbody", attributes, init)
    fun td(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("td", attributes, init)
    fun textarea(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("textarea", attributes, init)
    fun tfoot(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("tfoot", attributes, init)
    fun th(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("th", attributes, init)
    fun thead(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("thead", attributes, init)
    fun time(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("time", attributes, init)
    fun title(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("title", attributes, init)
    fun tr(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("tr", attributes, init)
    fun track(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("track", attributes, init)
    fun u(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("u", attributes, init)
    fun ul(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("ul", attributes, init)
    //    fun `var`(vararg attributes:Pair<String,Any>, init: Node.()->Unit):Node = tag("`var`", attributes, init)
    fun video(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("video", attributes, init)

    fun wbr(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("wbr", attributes, init)
    // SVG
    fun circle(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("circle", attributes, init)

    fun clipPath(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("clipPath", attributes, init)
    fun defs(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("defs", attributes, init)
    fun ellipse(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("ellipse", attributes, init)
    fun g(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("g", attributes, init)
    fun image(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("image", attributes, init)
    fun line(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("line", attributes, init)
    fun linearGradient(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("linearGradient", attributes, init)
    fun mask(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("mask", attributes, init)
    fun path(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("path", attributes, init)
    fun pattern(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("pattern", attributes, init)
    fun polygon(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("polygon", attributes, init)
    fun polyline(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("polyline", attributes, init)
    fun radialGradient(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("radialGradient", attributes, init)
    fun rect(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("rect", attributes, init)
    fun stop(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("stop", attributes, init)
    fun svg(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("svg", attributes, init)
    fun text(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("text", attributes, init)
    fun tspan(vararg attributes: Pair<String, Any?>, init: (Node.() -> Unit)? = null): Node = tag("tspan", attributes, init)
}