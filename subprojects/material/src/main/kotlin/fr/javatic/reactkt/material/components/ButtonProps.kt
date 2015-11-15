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

import fr.javatic.reactkt.core.Props

class ButtonProps(
        val className: String? = null,
        val floating: Boolean? = null,
        val colored: Boolean? = null,
        val ripple: Boolean? = null,
        val raised: Boolean? = null,
        val primary: Boolean? = null,
        val accent: Boolean? = null,
        val icon: Boolean? = null,
        val mini: Boolean? = null,
        val disabled: Boolean? = false,
        val buttonFor: String? = null
) : Props()