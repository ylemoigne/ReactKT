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
import fr.javatic.reactkt.core.ReactDOM
import fr.javatic.reactkt.core.ReactElement
import fr.javatic.reactkt.core.events.FormEvent
import fr.javatic.reactkt.core.events.KeyboardEvent
import fr.javatic.reactkt.core.ktx
import fr.javatic.reactkt.core.utils.Classes
import fr.javatic.reactkt.core.utils.KeyCode
import fr.javatic.reactktSample.core.interfaces.TodoItemProps
import fr.javatic.reactktSample.core.interfaces.TodoItemState
import org.w3c.dom.html.HTMLInputElement

class TodoItem(override var props: TodoItemProps) : Component<TodoItemProps, TodoItemState>() {
    init {
        state = TodoItemState(this.props.todo.title)
    }

    fun handleSubmit() {
        val value = this.state.editText.trim()
        if (value.isNotBlank()) {
            this.props.onSave(value)
            this.setState(TodoItemState(value))
        } else {
            this.props.onDestroy()
        }
    }

    fun handleEdit() {
        this.props.onEdit()
        this.setState(TodoItemState(this.props.todo.title))
    }

    fun handleKeyDown(event: KeyboardEvent) {
        if (event.keyCode == KeyCode.ESCAPE) {
            this.setState(TodoItemState(this.props.todo.title))
            this.props.onCancel(event)
        } else if (event.keyCode == KeyCode.ENTER) {
            this.handleSubmit()
        }
    }

    fun handleChange(event: FormEvent) {
        var input: dynamic = event.target
        this.setState(TodoItemState(input.value))
    }

    /**
     * This is a completely optional performance enhancement that you can
     * implement on any React component. If you were to delete this method
     * the app would still work correctly (and still be very performant!), we
     * just use it as an example of how little code it takes to get an order
     * of magnitude performance improvement.
     */
    override fun shouldComponentUpdate(nextProps: TodoItemProps, nextState: TodoItemState): Boolean {
        return (nextProps.todo != this.props.todo) ||
                (nextProps.editing != this.props.editing) ||
                (nextState.editText != this.state.editText)
    }

    /**
     * Safely manipulate the DOM after updating the state when invoking
     * `this.props.onEdit()` in the `handleEdit` method above.
     * For more info refer to notes at https://facebook.github.io/react/docs/component-api.html#setstate
     * and https://facebook.github.io/react/docs/component-specs.html#updating-componentdidupdate
     */
    override fun componentDidUpdate(prevProps: TodoItemProps):Unit {
        if (!(prevProps.editing ?: false) && this.props.editing ?: false) {
            val node = ReactDOM.findDOMNode<HTMLInputElement>(this.refs.get("editField"))
            if(node==null){
                return;
            }

            node.focus()
            node.setSelectionRange(node.value.length, node.value.length)
        }
    }

    override fun render(): ReactElement {
        val classes = Classes()
        classes.add(this.props.todo.completed, "completed")
        classes.add(this.props.editing, "editing")

        return ktx {
            li("className" to classes.build()) {
                div("className" to "view") {
                    input("className" to "toggle", "type" to "checkbox", "checked" to props.todo.completed, "onChange" to props.onToggle)
                    label("onDoubleClick" to { e: KeyboardEvent -> handleEdit() }) { +props.todo.title }
                    button("className" to "destroy", "onClick" to props.onDestroy)
                }
                input("ref" to "editField", "className" to "edit", "value" to state.editText, "onBlur" to { e: FormEvent -> handleSubmit() }, "onChange" to { e: FormEvent -> handleChange(e) }, "onKeyDown" to { e: KeyboardEvent -> handleKeyDown(e) })
            }
        }
    }
}