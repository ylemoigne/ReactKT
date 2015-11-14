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

import fr.javatic.reactkt.core.ktx
import fr.javatic.reactkt.core.utils.Classes
import fr.javatic.reactkt.material.MaterialComponent

class Badge : MaterialComponent<BadgeProps>() {
    fun render(): Any {
        val classes = Classes("mdl-badge", props.className)
        classes.add(props.nobackground, "mdl-badge--no-background")
        classes.add(props.overlap, "mdl-badge--overlap")
        classes.add(props.icon, "material-icons")

        return ktx {
            span("disabled" to props.disabled, "className" to classes.build(), "data-badge" to props.data) { +props.children }
        }
    }
}