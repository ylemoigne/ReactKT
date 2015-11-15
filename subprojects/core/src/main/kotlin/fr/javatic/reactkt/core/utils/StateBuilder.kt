
package fr.javatic.reactkt.core.utils

import fr.javatic.reactkt.core.binding.JsObject
import kotlin.reflect.KProperty1

class StateBuilder<T> {
    private val properties:MutableList<Pair<KProperty1<T,*>,*>> = arrayListOf()

    fun <V> p(p:Pair<KProperty1<T, V>, V>): StateBuilder<T> {
        properties.add(p)
        return this
    }

    fun toJsObject(): JsObject<Any> {
        val obj = JsObject<Any>()
        properties.forEach { p->obj.set(p.first.name, p.second) }
        return obj
    }
}