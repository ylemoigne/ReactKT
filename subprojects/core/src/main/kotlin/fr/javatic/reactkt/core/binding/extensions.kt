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

fun Iterable<Pair<String, Any?>>.toJsObject(): dynamic {
    val inst = JsObject<Any>()

    this.forEach { p -> inst.set(p.first, p.second) }

    return inst
}

// NOTE: in fact we generally don't need as Collection<T> already has toTypedArray that does what we need and most data
//  structures are Collections rather than Iterable.
internal fun Iterable<Any>.toJsArray(): dynamic {
    return toList().toTypedArray()
}