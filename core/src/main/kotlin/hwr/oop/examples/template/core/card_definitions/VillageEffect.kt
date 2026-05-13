package hwr.oop.examples.template.core.card_definitions

import hwr.oop.examples.template.core.PlayableCardEffect
import hwr.oop.examples.template.core.PlayerTurnGameState

class VillageEffect: PlayableCardEffect {
    override val additionalDraws: Int = 1
    override val additionalMoney: Int = 2
    override val additionalPurchases: Int = 1
    override val additionalActions: Int = 1

    override fun apply(playerTurnGameState: PlayerTurnGameState): PlayerTurnGameState {
        return grantCardValues(playerTurnGameState)
    }
}
