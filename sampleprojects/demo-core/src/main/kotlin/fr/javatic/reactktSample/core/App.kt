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
import fr.javatic.reactkt.core.binding.toJsObject
import fr.javatic.reactkt.core.events.FormEvent
import fr.javatic.reactkt.core.events.KeyboardEvent
import fr.javatic.reactkt.core.ktx
import fr.javatic.reactkt.core.utils.KeyCode
import fr.javatic.reactktSample.core.interfaces.*

class App : Component<AppProps, AppState>() {
    companion object {
        val ALL_TODOS = "all"
        val ACTIVE_TODOS = "active"
        val COMPLETED_TODOS = "completed"
    }

    init {
        this.state = AppState(
                nowShowing = App.ALL_TODOS,
                editing = null)
    }

    fun componentDidMount() {
        var router = Router(listOf("/" to { setState(AppState(editing = state.editing, nowShowing = App.ALL_TODOS)) },
                "/active" to { setState(AppState(editing = state.editing, nowShowing = App.ACTIVE_TODOS)) },
                "/completed" to { setState(AppState(editing = state.editing, nowShowing = App.COMPLETED_TODOS)) }
        ).toJsObject())
        router.init("/");
    }

    fun handleNewTodoKeyDown(event: KeyboardEvent) {
        if (event.keyCode != KeyCode.ENTER) {
            return;
        }

        event.preventDefault();

        val node: dynamic = ReactDOM.findDOMNode(this.refs.get("newField"))
        var value = node.value.trim();
        if (value != null) {
            this.props.model.addTodo(value)
            node.value = ""
        }
    }

    fun toggleAll(event: FormEvent) {
        var target: dynamic = event.target;
        var checked = target.checked;
        this.props.model.toggleAll(checked);
    }

    fun toggle(todoToToggle: Todo) {
        this.props.model.toggle(todoToToggle);
    }

    fun destroy(todo: Todo) {
        this.props.model.destroy(todo);
    }

    fun edit(todo: Todo) {
        this.setState(AppState(editing = todo.id, nowShowing = this.state.nowShowing));
    }

    fun save(todoToSave: Todo, text: String) {
        this.props.model.save(todoToSave, text);
        this.setState(AppState(editing = null, nowShowing = this.state.nowShowing));
    }

    fun cancel() {
        this.setState(AppState(editing = null, nowShowing = this.state.nowShowing));
    }

    fun clearCompleted() {
        this.props.model.clearCompleted();
    }

    fun render(): Any {
        val todos = this.props.model.todos;

        var shownTodos = todos.filter { todo ->
            when (this.state.nowShowing) {
                ACTIVE_TODOS -> !todo.completed
                COMPLETED_TODOS -> todo.completed
                else -> true
            }
        }

        var todoItems = shownTodos.map { todo ->
            ktx {
                component(::TodoItem, TodoItemProps(key = todo.id,
                        todo = todo,
                        onToggle = { toggle(todo) },
                        onDestroy = { destroy(todo) },
                        onEdit = { edit(todo) },
                        editing = state.editing == todo.id,
                        onSave = { save(todo, "") },
                        onCancel = { e -> cancel() }))
            }
        }

        // Note: It's usually better to use immutable data structures since they're
        // easier to reason about and React works very well with them. That's why
        // we use map(), filter() and reduce() everywhere instead of mutating the
        // array or todo items themselves.
        var activeTodoCount = todos.fold(0) { accum, todo ->
            if (todo.completed) accum else accum + 1
        }

        var completedCount = todos.size - activeTodoCount;

        val footer = if (activeTodoCount != 0 || completedCount != 0) {
            ktx {
                component(::TodoFooter, TodoFooterProps(count = activeTodoCount,
                        completedCount = completedCount,
                        nowShowing = state.nowShowing!!,
                        onClearCompleted = { e: KeyboardEvent -> clearCompleted() }))
            }
        } else null

        val main = if (todos.size != 0) {
            ktx {
                section("className" to "main") {
                    input("className" to "toggle-all", "type" to "checkbox", "onChange" to { e: FormEvent -> toggleAll(e) }, "checked" to (activeTodoCount == 0))
                    ul("className" to "todo-list") {
                        +todoItems
                    }
                }
            }
        } else null

        return ktx {
            div() {
                header("className" to "header") {
                    h1 { +"todos" }
                    input("ref" to "newField",
                            "className" to "new-todo",
                            "placeholder" to "What needs to be done?",
                            "onKeyDown" to { e: KeyboardEvent -> handleNewTodoKeyDown(e) },
                            "autoFocus" to true)
                }
                +main
                +footer
            }
        }
    }
}