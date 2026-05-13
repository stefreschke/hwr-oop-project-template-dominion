package hwr.oop.examples.template.core.card_definitions

import hwr.oop.examples.template.core.PlayerTurnGameState
import hwr.oop.examples.template.core.ResourceCardEffect
import hwr.oop.examples.template.core.ResourceCardResourceType

class CopperEffect: ResourceCardEffect {
    override val type: ResourceCardResourceType = ResourceCardResourceType.Treasure
    override val value: Int = 3

    override fun apply(playerTurnGameState: PlayerTurnGameState): PlayerTurnGameState {
        return applyResource(playerTurnGameState)
    }
}
