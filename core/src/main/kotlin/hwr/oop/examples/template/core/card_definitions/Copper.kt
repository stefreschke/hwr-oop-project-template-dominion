package hwr.oop.examples.template.core.card_definitions

import hwr.oop.examples.template.core.Card

class Copper : Card {
    override val name: String = "Copper"
    override val cost: Int = 2
    override val cardEffect: CopperEffect = CopperEffect()
}