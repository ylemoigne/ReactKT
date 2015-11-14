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

package fr.javatic.reactktSample.core

import fr.javatic.reactkt.core.Component
import fr.javatic.reactkt.core.ktx
import fr.javatic.reactktSample.core.interfaces.TodoFooterProps

class TodoFooter : Component<TodoFooterProps, Any>() {
    fun render(): Any {
        var activeTodoWord = Utils.pluralize(this.props.count, "item");

        var clearButton = if (this.props.completedCount > 0) {
            ktx {
                button("className" to "clear-completed",
                        "onClick" to props.onClearCompleted) {
                    +"Clear completed"
                }
            }
        } else null

        val nowShowing = this.props.nowShowing;
        return ktx {
            footer("className" to "footer") {
                span("className" to "todo-count") {
                    strong() { +props.count.toString() }
                    +" "
                    +activeTodoWord
                    +" left"
                }
                ul("className" to "filters") {
                    li {
                        a("href" to "#/", "className" to if (nowShowing == App.ALL_TODOS) "selected" else null) {
                            +"All"
                        }
                    }
                    +" "
                    li {
                        a("href" to "#/active", "className" to if (nowShowing == App.ACTIVE_TODOS) "selected" else null) {
                            +"Active"
                        }
                    }
                    +" "
                    li {
                        a("href" to "#/completed", "className" to if (nowShowing == App.COMPLETED_TODOS) "selected" else null) {
                            +"Completed"
                        }
                    }
                }
                +clearButton
            }
        }
    }
}