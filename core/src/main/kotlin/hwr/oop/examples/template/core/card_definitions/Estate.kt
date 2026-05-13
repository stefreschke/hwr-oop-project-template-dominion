package hwr.oop.examples.template.core.card_definitions

import hwr.oop.examples.template.core.Card
import hwr.oop.examples.template.core.CardEffect

class Estate: Card {
    override val name: String = "Estate"
    override val cost: Int = 4
    override val cardEffect: CardEffect = EstateEffect()
}
