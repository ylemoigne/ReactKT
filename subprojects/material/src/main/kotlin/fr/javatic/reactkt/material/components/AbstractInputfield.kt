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

package fr.javatic.reactkt.material.components

import fr.javatic.reactkt.core.ReactElement
import fr.javatic.reactkt.core.ktx
import fr.javatic.reactkt.core.utils.Classes
import fr.javatic.reactkt.material.MaterialComponent

abstract class AbstractInputfield<P : AbstractInputfieldProps> : MaterialComponent<P>() {
    companion object {
        val inputClasses = "mdl-textfield__input"
    }

    abstract fun createConcreteField(id: String): ReactElement

    fun render(): Any {
        val classes = Classes("mdl-textfield", "mdl-js-textfield", props.className)
        classes.add(this.props.floatingLabel, "mdl-textfield--floating-label")
        classes.add(this.props.expandable, "mdl-textfield--expandable")
        classes.add(this.props.button, "mdl-button", "mdl-js-button")
        classes.add(this.props.icon, "mdl-button--icon")
        classes.add(this.props.expandableHolder, "mdl-textfield__expandable-holder")

        //            id = "_" + Math.random().toString(36).slice(2);
        val id = this.props.id ?: "_" + Math.random().toString()

        val textfield = createConcreteField(id)

        val labelField = if (this.props.label != null) {
            ktx {
                label("className" to "mdl-textfield__label", "htmlFor" to id) { +props.label }
            }
        } else {
            null
        }

        val errorField = if (this.props.error != null) {
            ktx {
                span("className" to "mdl-textfield__error") { +props.error }
            }
        } else {
            null
        }

        return ktx {
            div("className" to classes.build()) {
                +textfield
                +labelField
                +errorField
            }
        }
    }
}