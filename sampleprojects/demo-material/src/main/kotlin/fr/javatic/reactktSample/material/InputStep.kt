package fr.javatic.reactktSample.material

import fr.javatic.reactkt.core.Component
import fr.javatic.reactkt.core.ReactElement
import fr.javatic.reactkt.core.ktx
import fr.javatic.reactkt.material.components.Button
import fr.javatic.reactkt.material.components.ButtonProps
import fr.javatic.reactkt.material.components.Textarea
import fr.javatic.reactkt.material.components.TextareaProps

class InputStep : Component<InputStepProp, Any>() {
    override fun render(): ReactElement {
        return ktx {
            div {
                div ("className" to "cell mdl-cell--12-col") {
                    component(::Textarea, TextareaProps(label = "Argument", rows = 20, cols = 600, defaultValue = props.input))
                    component(::Button, ButtonProps(raised = true, primary = true)) { +"OK" }
                }
            }
        }
    }
}