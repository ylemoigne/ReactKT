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

package org.w3c.dom.html

import org.w3c.dom.Node

/**
 *  An <code>HTMLCollection</code> is a list of nodes. An individual node may
 * be accessed by either ordinal index or the node's<code>name</code> or
 * <code>id</code> attributes.  Note: Collections in the HTML DOM are assumed
 * to be  live meaning that they are automatically updated when the
 * underlying document is changed.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
interface HTMLCollection {
    /**
     * This attribute specifies the length or  size of the list.
     */
    fun getLength(): Int

    /**
     * This method retrieves a node specified by ordinal index. Nodes are
     * numbered in tree order (depth-first traversal order).
     * @param index  The index of the node to be fetched. The index origin is
     * *   0.
     * *
     * @return  The `Node` at the corresponding position upon
     * *   success. A value of `null` is returned if the index is
     * *   out of range.
     */
    fun item(index: Int): Node

    /**
     * This method retrieves a `Node` using a name. It first
     * searches for a `Node` with a matching `id`
     * attribute. If it doesn't find one, it then searches for a
     * `Node` with a matching `name` attribute, but
     * only on those elements that are allowed a name attribute.
     * @param name  The name of the `Node` to be fetched.
     * *
     * @return  The `Node` with a `name` or
     * *   `id` attribute whose value corresponds to the specified
     * *   string. Upon failure (e.g., no node with this name exists), returns
     * *   `null` .
     */
    fun namedItem(name: String): Node
}