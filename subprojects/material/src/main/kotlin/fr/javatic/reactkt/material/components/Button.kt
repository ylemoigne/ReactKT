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

class Button : MaterialComponent<ButtonProps>() {
    override fun render(): ReactElement {
        val classes = Classes("mdl-button", "mdl-js-button raised", props.className)
        classes.add(props.floating, "mdl-button--fab")
        classes.add(props.colored, "mdl-button--colored")
        classes.add(props.ripple, "mdl-js-ripple-effect")
        classes.add(props.raised, "mdl-button--raised")
        classes.add(props.primary, "mdl-button--primary")
        classes.add(props.accent, "mdl-button--accent")
        classes.add(props.icon, "mdl-button--icon")
        classes.add(props.floating ?: false && props.mini ?: false, "mdl-button--mini-fab")

        return ktx {
            button("disabled" to props.disabled, "className" to classes.build()) { +props.children }
        }
    }
}