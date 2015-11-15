package fr.javatic.reactktSample.material

import fr.javatic.reactkt.core.Component
import fr.javatic.reactkt.core.ReactElement
import fr.javatic.reactkt.core.ktx
import fr.javatic.reactkt.material.components.*
import fr.javatic.reactkt.material.components.LayoutFixedDrawer
import fr.javatic.reactkt.material.components.data.NavLink

class App : Component<Any,AppState>() {
    init {
        this.state = AppState(Step.Input, "")
    }

    override fun render(): ReactElement {
        val content = when(this.state.display){
            Step.Input -> ktx { component(::InputStep, InputStepProp(state.input)) }
            else -> ktx { div("className" to "mdl-cell mdl-cell--12-col") {+"Something need to be done"} }
        }

        return ktx {
            component(::LayoutFixedDrawer, LayoutDrawerProps("I'm the title", NavLink("a", "A"),NavLink("b", "B"),NavLink("c", "C"),NavLink("d", "D"))) {
                div("className" to "mdl-grid") {
                        +content
                }
            }
        }
    }
}