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

package fr.javatic.reactkt.core.binding

import fr.javatic.reactkt.core.ReactElement

@native("React")
internal object InternalReact {


    //    @native("createClass")
    //    fun createClass(spec:dynamic):ReactClass

    @native("createElement")
    fun createElement(component: dynamic, props: dynamic, vararg childs: dynamic): ReactElement

    @native("cloneElement")
    fun cloneElement(element: dynamic, props: dynamic, vararg childs: dynamic): ReactElement

    //    @native("createFactory")
    //    fun createFactory(type:dynamic):FactoryFunction

    //    @native("isValidElement")
    //    fun isValidElement(obj:dynamic):Boolean

    @native("DOM")
    object DOM {
        @native("a") fun a(props: dynamic, vararg childs: dynamic): ReactElement
        @native("abbr") fun abbr(props: dynamic, vararg childs: dynamic): ReactElement
        @native("address") fun address(props: dynamic, vararg childs: dynamic): ReactElement
        @native("area") fun area(props: dynamic, vararg childs: dynamic): ReactElement
        @native("article") fun article(props: dynamic, vararg childs: dynamic): ReactElement
        @native("aside") fun aside(props: dynamic, vararg childs: dynamic): ReactElement
        @native("audio") fun audio(props: dynamic, vararg childs: dynamic): ReactElement
        @native("b") fun b(props: dynamic, vararg childs: dynamic): ReactElement
        @native("base") fun base(props: dynamic, vararg childs: dynamic): ReactElement
        @native("bdi") fun bdi(props: dynamic, vararg childs: dynamic): ReactElement
        @native("bdo") fun bdo(props: dynamic, vararg childs: dynamic): ReactElement
        @native("big") fun big(props: dynamic, vararg childs: dynamic): ReactElement
        @native("blockquote") fun blockquote(props: dynamic, vararg childs: dynamic): ReactElement
        @native("body") fun body(props: dynamic, vararg childs: dynamic): ReactElement
        @native("br") fun br(props: dynamic, vararg childs: dynamic): ReactElement
        @native("button") fun button(props: dynamic, vararg childs: dynamic): ReactElement
        @native("canvas") fun canvas(props: dynamic, vararg childs: dynamic): ReactElement
        @native("caption") fun caption(props: dynamic, vararg childs: dynamic): ReactElement
        @native("cite") fun cite(props: dynamic, vararg childs: dynamic): ReactElement
        @native("code") fun code(props: dynamic, vararg childs: dynamic): ReactElement
        @native("col") fun col(props: dynamic, vararg childs: dynamic): ReactElement
        @native("colgroup") fun colgroup(props: dynamic, vararg childs: dynamic): ReactElement
        @native("data") fun data(props: dynamic, vararg childs: dynamic): ReactElement
        @native("datalist") fun datalist(props: dynamic, vararg childs: dynamic): ReactElement
        @native("dd") fun dd(props: dynamic, vararg childs: dynamic): ReactElement
        @native("del") fun del(props: dynamic, vararg childs: dynamic): ReactElement
        @native("details") fun details(props: dynamic, vararg childs: dynamic): ReactElement
        @native("dfn") fun dfn(props: dynamic, vararg childs: dynamic): ReactElement
        @native("dialog") fun dialog(props: dynamic, vararg childs: dynamic): ReactElement
        @native("div") fun div(props: dynamic, vararg childs: dynamic): ReactElement
        @native("dl") fun dl(props: dynamic, vararg childs: dynamic): ReactElement
        @native("dt") fun dt(props: dynamic, vararg childs: dynamic): ReactElement
        @native("em") fun em(props: dynamic, vararg childs: dynamic): ReactElement
        @native("embed") fun embed(props: dynamic, vararg childs: dynamic): ReactElement
        @native("fieldset") fun fieldset(props: dynamic, vararg childs: dynamic): ReactElement
        @native("figcaption") fun figcaption(props: dynamic, vararg childs: dynamic): ReactElement
        @native("figure") fun figure(props: dynamic, vararg childs: dynamic): ReactElement
        @native("footer") fun footer(props: dynamic, vararg childs: dynamic): ReactElement
        @native("form") fun form(props: dynamic, vararg childs: dynamic): ReactElement
        @native("h1") fun h1(props: dynamic, vararg childs: dynamic): ReactElement
        @native("h2") fun h2(props: dynamic, vararg childs: dynamic): ReactElement
        @native("h3") fun h3(props: dynamic, vararg childs: dynamic): ReactElement
        @native("h4") fun h4(props: dynamic, vararg childs: dynamic): ReactElement
        @native("h5") fun h5(props: dynamic, vararg childs: dynamic): ReactElement
        @native("h6") fun h6(props: dynamic, vararg childs: dynamic): ReactElement
        @native("head") fun head(props: dynamic, vararg childs: dynamic): ReactElement
        @native("header") fun header(props: dynamic, vararg childs: dynamic): ReactElement
        @native("hgroup") fun hgroup(props: dynamic, vararg childs: dynamic): ReactElement
        @native("hr") fun hr(props: dynamic, vararg childs: dynamic): ReactElement
        @native("html") fun html(props: dynamic, vararg childs: dynamic): ReactElement
        @native("i") fun i(props: dynamic, vararg childs: dynamic): ReactElement
        @native("iframe") fun iframe(props: dynamic, vararg childs: dynamic): ReactElement
        @native("img") fun img(props: dynamic, vararg childs: dynamic): ReactElement
        @native("input") fun input(props: dynamic, vararg childs: dynamic): ReactElement
        @native("ins") fun ins(props: dynamic, vararg childs: dynamic): ReactElement
        @native("kbd") fun kbd(props: dynamic, vararg childs: dynamic): ReactElement
        @native("keygen") fun keygen(props: dynamic, vararg childs: dynamic): ReactElement
        @native("label") fun label(props: dynamic, vararg childs: dynamic): ReactElement
        @native("legend") fun legend(props: dynamic, vararg childs: dynamic): ReactElement
        @native("li") fun li(props: dynamic, vararg childs: dynamic): ReactElement
        @native("link") fun link(props: dynamic, vararg childs: dynamic): ReactElement
        @native("main") fun main(props: dynamic, vararg childs: dynamic): ReactElement
        @native("map") fun map(props: dynamic, vararg childs: dynamic): ReactElement
        @native("mark") fun mark(props: dynamic, vararg childs: dynamic): ReactElement
        @native("menu") fun menu(props: dynamic, vararg childs: dynamic): ReactElement
        @native("menuitem") fun menuitem(props: dynamic, vararg childs: dynamic): ReactElement
        @native("meta") fun meta(props: dynamic, vararg childs: dynamic): ReactElement
        @native("meter") fun meter(props: dynamic, vararg childs: dynamic): ReactElement
        @native("nav") fun nav(props: dynamic, vararg childs: dynamic): ReactElement
        @native("noscript") fun noscript(props: dynamic, vararg childs: dynamic): ReactElement
        @native("`object`") fun `object`(props: dynamic, vararg childs: dynamic): ReactElement
        @native("ol") fun ol(props: dynamic, vararg childs: dynamic): ReactElement
        @native("optgroup") fun optgroup(props: dynamic, vararg childs: dynamic): ReactElement
        @native("option") fun option(props: dynamic, vararg childs: dynamic): ReactElement
        @native("output") fun output(props: dynamic, vararg childs: dynamic): ReactElement
        @native("p") fun p(props: dynamic, vararg childs: dynamic): ReactElement
        @native("param") fun param(props: dynamic, vararg childs: dynamic): ReactElement
        @native("picture") fun picture(props: dynamic, vararg childs: dynamic): ReactElement
        @native("pre") fun pre(props: dynamic, vararg childs: dynamic): ReactElement
        @native("progress") fun progress(props: dynamic, vararg childs: dynamic): ReactElement
        @native("q") fun q(props: dynamic, vararg childs: dynamic): ReactElement
        @native("rp") fun rp(props: dynamic, vararg childs: dynamic): ReactElement
        @native("rt") fun rt(props: dynamic, vararg childs: dynamic): ReactElement
        @native("ruby") fun ruby(props: dynamic, vararg childs: dynamic): ReactElement
        @native("s") fun s(props: dynamic, vararg childs: dynamic): ReactElement
        @native("samp") fun samp(props: dynamic, vararg childs: dynamic): ReactElement
        @native("script") fun script(props: dynamic, vararg childs: dynamic): ReactElement
        @native("section") fun section(props: dynamic, vararg childs: dynamic): ReactElement
        @native("select") fun select(props: dynamic, vararg childs: dynamic): ReactElement
        @native("small") fun small(props: dynamic, vararg childs: dynamic): ReactElement
        @native("source") fun source(props: dynamic, vararg childs: dynamic): ReactElement
        @native("span") fun span(props: dynamic, vararg childs: dynamic): ReactElement
        @native("strong") fun strong(props: dynamic, vararg childs: dynamic): ReactElement
        @native("style") fun style(props: dynamic, vararg childs: dynamic): ReactElement
        @native("sub") fun sub(props: dynamic, vararg childs: dynamic): ReactElement
        @native("summary") fun summary(props: dynamic, vararg childs: dynamic): ReactElement
        @native("sup") fun sup(props: dynamic, vararg childs: dynamic): ReactElement
        @native("table") fun table(props: dynamic, vararg childs: dynamic): ReactElement
        @native("tbody") fun tbody(props: dynamic, vararg childs: dynamic): ReactElement
        @native("td") fun td(props: dynamic, vararg childs: dynamic): ReactElement
        @native("textarea") fun textarea(props: dynamic, vararg childs: dynamic): ReactElement
        @native("tfoot") fun tfoot(props: dynamic, vararg childs: dynamic): ReactElement
        @native("th") fun th(props: dynamic, vararg childs: dynamic): ReactElement
        @native("thead") fun thead(props: dynamic, vararg childs: dynamic): ReactElement
        @native("time") fun time(props: dynamic, vararg childs: dynamic): ReactElement
        @native("title") fun title(props: dynamic, vararg childs: dynamic): ReactElement
        @native("tr") fun tr(props: dynamic, vararg childs: dynamic): ReactElement
        @native("track") fun track(props: dynamic, vararg childs: dynamic): ReactElement
        @native("u") fun u(props: dynamic, vararg childs: dynamic): ReactElement
        @native("ul") fun ul(props: dynamic, vararg childs: dynamic): ReactElement
        @native("`var`") fun `var`(props: dynamic, vararg childs: dynamic): ReactElement
        @native("video") fun video(props: dynamic, vararg childs: dynamic): ReactElement
        @native("wbr") fun wbr(props: dynamic, vararg childs: dynamic): ReactElement

        // SVG
        @native("circle") fun circle(props: dynamic, vararg childs: dynamic): ReactElement

        @native("clipPath") fun clipPath(props: dynamic, vararg childs: dynamic): ReactElement
        @native("defs") fun defs(props: dynamic, vararg childs: dynamic): ReactElement
        @native("ellipse") fun ellipse(props: dynamic, vararg childs: dynamic): ReactElement
        @native("g") fun g(props: dynamic, vararg childs: dynamic): ReactElement
        @native("image") fun image(props: dynamic, vararg childs: dynamic): ReactElement
        @native("line") fun line(props: dynamic, vararg childs: dynamic): ReactElement
        @native("linearGradient") fun linearGradient(props: dynamic, vararg childs: dynamic): ReactElement
        @native("mask") fun mask(props: dynamic, vararg childs: dynamic): ReactElement
        @native("path") fun path(props: dynamic, vararg childs: dynamic): ReactElement
        @native("pattern") fun pattern(props: dynamic, vararg childs: dynamic): ReactElement
        @native("polygon") fun polygon(props: dynamic, vararg childs: dynamic): ReactElement
        @native("polyline") fun polyline(props: dynamic, vararg childs: dynamic): ReactElement
        @native("radialGradient") fun radialGradient(props: dynamic, vararg childs: dynamic): ReactElement
        @native("rect") fun rect(props: dynamic, vararg childs: dynamic): ReactElement
        @native("stop") fun stop(props: dynamic, vararg childs: dynamic): ReactElement
        @native("svg") fun svg(props: dynamic, vararg childs: dynamic): ReactElement
        @native("text") fun text(props: dynamic, vararg childs: dynamic): ReactElement
        @native("tspan") fun tspan(props: dynamic, vararg childs: dynamic): ReactElement
    }

    @native("Children")
    object Children {
        @native("map") fun map(children: dynamic, f: (dynamic) -> dynamic): Array<dynamic>
        @native("forEach") fun forEach(children: dynamic, f: (dynamic) -> Unit): Unit
        @native("count") fun count(children: dynamic): Int
        @native("only") fun only(children: dynamic): dynamic
        @native("toArray") fun toArray(children: dynamic): Array<dynamic>
    }
}