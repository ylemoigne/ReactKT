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

class TodoItemProps(val key: String,
                    val todo: Todo,
                    val editing: Boolean?,
                    val onSave: (v: String) -> Unit,
                    val onDestroy: () -> Unit,
                    val onEdit: () -> Unit,
                    val onCancel: (event: Any) -> Unit,
                    val onToggle: () -> Unit)