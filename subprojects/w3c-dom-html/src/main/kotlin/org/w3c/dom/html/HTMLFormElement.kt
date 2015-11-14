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

/**
 *  The <code>FORM</code> element encompasses behavior similar to a collection
 * and an element. It provides direct access to the contained input elements
 * as well as the attributes of the form element. See the  FORM element
 * definition in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
interface HTMLFormElement : HTMLElement {
    /**
     * Returns a collection of all control elements in the form.
     */
    fun getElements(): HTMLCollection

    /**
     * The number of form controls in the form.
     */
    fun getLength(): Int

    /**
     * Names the form.
     */
    fun getName(): String

    fun setName(name: String)

    /**
     * List of character sets supported by the server. See the
     * accept-charset attribute definition in HTML 4.0.
     */
    fun getAcceptCharset(): String

    fun setAcceptCharset(acceptCharset: String)

    /**
     * Server-side form handler. See the  action attribute definition in HTML
     * 4.0.
     */
    fun getAction(): String

    fun setAction(action: String)

    /**
     * The content type of the submitted form,  generally
     * "application/x-www-form-urlencoded".  See the  enctype attribute
     * definition in HTML 4.0.
     */
    fun getEnctype(): String

    fun setEnctype(enctype: String)

    /**
     * HTTP method used to submit form. See the  method attribute definition
     * in HTML 4.0.
     */
    fun getMethod(): String

    fun setMethod(method: String)

    /**
     * Frame to render the resource in. See the  target attribute definition
     * in HTML 4.0.
     */
    fun getTarget(): String

    fun setTarget(target: String)

    /**
     * Submits the form. It performs the same action as a  submit button.
     */
    fun submit()

    /**
     * Restores a form element's default values. It performs  the same action
     * as a reset button.
     */
    fun reset()

}