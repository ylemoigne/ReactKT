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

package fr.javatic.reactktSample.core.interfaces

import fr.javatic.reactktSample.core.Utils

class TodoModel(val key: String) {
    var todos: List<Todo>
    val onChanges: MutableList<() -> Any?>

    init {
        todos = Utils.store(key)
        onChanges = arrayListOf()
    }

    fun subscribe(onChange: () -> Any?) {
        onChanges.add(onChange)
    }

    fun inform() {
        Utils.store(this.key, this.todos);
        this.onChanges.forEach { cb -> cb.invoke() }
    }

    fun addTodo(title: String) {
        this.todos = this.todos + Todo(Utils.uuid(), title, false)
        this.inform()
    }

    fun toggleAll(checked: Boolean) {
        // Note: It's usually better to use immutable data structures since they're
        // easier to reason about and React works very well with them. That's why
        // we use map(), filter() and reduce() everywhere instead of mutating the
        // array or todo items themselves.
        this.todos = this.todos.map { todo -> Todo(completed = checked, id = todo.id, title = todo.title) }

        this.inform();
    }

    fun toggle(todoToToggle: Todo) {
        this.todos = this.todos.map { todo ->
            if (todo != todoToToggle) todo else Todo(completed = !todo.completed, id = todo.id, title = todo.title)
        }

        this.inform();
    }

    fun destroy(todo: Todo) {
        this.todos = this.todos.filter { t -> t != todo }
        this.inform()
    }

    fun save(todoToSave: Todo, text: String) {
        this.todos = this.todos.map { todo -> if (todo != todoToSave) todo else Todo(title = text, id = todo.id, completed = todo.completed) }
        this.inform()
    }

    fun clearCompleted() {
        this.todos = this.todos.filter { todo -> !todo.completed }
        this.inform()
    }
}