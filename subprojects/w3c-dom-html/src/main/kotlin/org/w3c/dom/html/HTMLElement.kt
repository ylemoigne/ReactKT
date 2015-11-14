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

import org.w3c.dom.Element

/**
 *  All HTML element interfaces derive from this class. Elements that only
 * expose the HTML core attributes are represented by the base
 * <code>HTMLElement</code> interface. These elements are as follows:  HEAD
 * special: SUB, SUP, SPAN, BDO font: TT, I, B, U, S, STRIKE, BIG, SMALL
 * phrase: EM, STRONG, DFN, CODE, SAMP, KBD, VAR, CITE, ACRONYM, ABBR list:
 * DD, DT NOFRAMES, NOSCRIPT ADDRESS, CENTER The <code>style</code> attribute
 * of an HTML element is accessible through the
 * <code>ElementCSSInlineStyle</code> interface which is defined in the  .
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
interface HTMLElement : Element {
    /**
     * The element's identifier. See the  id attribute definition in HTML 4.0.
     */
    fun getId(): String

    fun setId(id: String)

    /**
     * The element's advisory title. See the  title attribute definition in
     * HTML 4.0.
     */
    fun getTitle(): String

    fun setTitle(title: String)

    /**
     * Language code defined in RFC 1766. See the  lang attribute definition
     * in HTML 4.0.
     */
    fun getLang(): String

    fun setLang(lang: String)

    /**
     * Specifies the base direction of directionally neutral text and the
     * directionality of tables. See the  dir attribute definition in HTML
     * 4.0.
     */
    fun getDir(): String

    fun setDir(dir: String)

    /**
     * The class attribute of the element. This attribute has been renamed
     * due to conflicts with the "class" keyword exposed by many languages.
     * See the  class attribute definition in HTML 4.0.
     */
    fun getClassName(): String

    fun setClassName(className: String)
}