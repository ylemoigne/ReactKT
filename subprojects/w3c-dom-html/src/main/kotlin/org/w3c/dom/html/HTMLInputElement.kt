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
 *  Form control.  Note. Depending upon the environment in which the page is
 * being viewed, the value property may be read-only for the file upload
 * input type. For the "password" input type, the actual value returned may
 * be masked to prevent unauthorized use. See the  INPUT element definition
 * in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
interface HTMLInputElement : HTMLElement {
    /**
     * When the `type` attribute of the element has the value
     * "Text", "File" or "Password", this represents the HTML value attribute
     * of the element. The value of this attribute does not change if the
     * contents of the corresponding form control, in an interactive user
     * agent, changes. Changing this attribute, however, resets the contents
     * of the form control. See the  value attribute definition in HTML 4.0.
     */
    fun getDefaultValue(): String

    fun setDefaultValue(defaultValue: String)

    /**
     * When `type` has the value "Radio" or "Checkbox", this
     * represents the HTML checked attribute of the element. The value of
     * this attribute does not change if the state of the corresponding form
     * control, in an interactive user agent, changes. Changes to this
     * attribute, however, resets the state of the form control. See the
     * checked attribute definition in HTML 4.0.
     */
    fun getDefaultChecked(): Boolean

    fun setDefaultChecked(defaultChecked: Boolean)

    /**
     * Returns the `FORM` element containing this control. Returns
     * `null` if this control is not within the context of a form.
     */
    fun getForm(): HTMLFormElement

    /**
     * A comma-separated list of content types that a server processing this
     * form will handle correctly. See the  accept attribute definition in
     * HTML 4.0.
     */
    fun getAccept(): String

    fun setAccept(accept: String)

    /**
     * A single character access key to give access to the form control. See
     * the  accesskey attribute definition in HTML 4.0.
     */
    fun getAccessKey(): String

    fun setAccessKey(accessKey: String)

    /**
     * Aligns this object (vertically or horizontally)  with respect to its
     * surrounding text. See the  align attribute definition in HTML 4.0.
     * This attribute is deprecated in HTML 4.0.
     */
    fun getAlign(): String

    fun setAlign(align: String)

    /**
     * Alternate text for user agents not rendering the normal content of
     * this element. See the  alt attribute definition in HTML 4.0.
     */
    fun getAlt(): String

    fun setAlt(alt: String)

    /**
     * When the `type` attribute of the element has the value
     * "Radio" or "Checkbox", this represents the current state of the form
     * control, in an interactive user agent. Changes to this attribute
     * change the state of the form control, but do not change the value of
     * the HTML value attribute of the element.
     */
    fun getChecked(): Boolean

    fun setChecked(checked: Boolean)

    /**
     * The control is unavailable in this context. See the  disabled
     * attribute definition in HTML 4.0.
     */
    fun getDisabled(): Boolean

    fun setDisabled(disabled: Boolean)

    /**
     * Maximum number of characters for text fields, when `type`
     * has the value "Text" or "Password". See the  maxlength attribute
     * definition in HTML 4.0.
     */
    fun getMaxLength(): Int

    fun setMaxLength(maxLength: Int)

    /**
     * Form control or object name when submitted with a form. See the  name
     * attribute definition in HTML 4.0.
     */
    fun getName(): String

    fun setName(name: String)

    /**
     * This control is read-only. Relevant only when `type` has
     * the value "Text" or "Password". See the  readonly attribute definition
     * in HTML 4.0.
     */
    fun getReadOnly(): Boolean

    fun setReadOnly(readOnly: Boolean)

    /**
     * Size information. The precise meaning is specific to each type of
     * field.  See the  size attribute definition in HTML 4.0.
     */
    fun getSize(): String

    fun setSize(size: String)

    /**
     * When the `type` attribute has the value "Image", this
     * attribute specifies the location of the image to be used to decorate
     * the graphical submit button. See the  src attribute definition in HTML
     * 4.0.
     */
    fun getSrc(): String

    fun setSrc(src: String)

    /**
     * Index that represents the element's position in the tabbing order. See
     * the  tabindex attribute definition in HTML 4.0.
     */
    fun getTabIndex(): Int

    fun setTabIndex(tabIndex: Int)

    /**
     * The type of control created. See the  type attribute definition in
     * HTML 4.0.
     */
    fun getType(): String

    /**
     * Use client-side image map. See the  usemap attribute definition in
     * HTML 4.0.
     */
    fun getUseMap(): String

    fun setUseMap(useMap: String)

    /**
     * When the `type` attribute of the element has the value
     * "Text", "File" or "Password", this represents the current contents of
     * the corresponding form control, in an interactive user agent. Changing
     * this attribute changes the contents of the form control, but does not
     * change the value of the HTML value attribute of the element. When the
     * `type` attribute of the element has the value "Button",
     * "Hidden", "Submit", "Reset", "Image", "Checkbox" or "Radio", this
     * represents the HTML value attribute of the element. See the  value
     * attribute definition in HTML 4.0.
     */
    fun getValue(): String

    fun setValue(value: String)

    /**
     * Removes keyboard focus from this element.
     */
    fun blur()

    /**
     * Gives keyboard focus to this element.
     */
    fun focus()

    /**
     * Select the contents of the text area. For `INPUT` elements
     * whose `type` attribute has one of the following values:
     * "Text", "File", or "Password".
     */
    fun select()

    /**
     * Simulate a mouse-click. For `INPUT` elements whose
     * `type` attribute has one of the following values: "Button",
     * "Checkbox", "Radio", "Reset", or "Submit".
     */
    fun click()

}