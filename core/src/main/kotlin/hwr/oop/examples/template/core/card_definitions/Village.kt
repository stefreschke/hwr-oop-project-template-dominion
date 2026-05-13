package hwr.oop.examples.template.core.card_definitions

import hwr.oop.examples.template.core.Card
import hwr.oop.examples.template.core.PlayableCardEffect

class Village : Card {
    override val name: String = "Village"
    override val cost: Int = 3
    override val cardEffect: PlayableCardEffect = VillageEffect()
}
