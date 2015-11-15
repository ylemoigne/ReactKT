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

import fr.javatic.reactkt.core.binding.JsObject
import fr.javatic.reactkt.core.utils.StateBuilder

@native("React.Component")
abstract class Component<P, S>() : ReactElement {
    /**
     * Warning : Object prototype will be lost
     */
    @native("setState")
    fun setState(state: dynamic): Unit

    open var props: P
    var state: S
    var refs: JsObject<ReactElement>

    open fun componentDidMount(): Unit
    open fun componentWillUnmount(): Unit
    open fun componentDidUpdate(prevProps: P): Unit
    open fun shouldComponentUpdate(nextProps: P, nextState: S): Boolean

    abstract fun render(): ReactElement

}

fun <P, S> Component<P, S>.setStatePartial(init: StateBuilder<S>.() -> Unit): Unit {
    val builder = StateBuilder<S>()
    builder.init()
    setState(builder.toJsObject())
}