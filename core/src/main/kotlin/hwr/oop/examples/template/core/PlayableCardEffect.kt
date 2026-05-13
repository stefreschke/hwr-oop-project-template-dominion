package hwr.oop.examples.template.core

interface PlayableCardEffect : CardEffect{
    val additionalDraws: Int
    val additionalMoney: Int
    val additionalPurchases: Int
    val additionalActions: Int

    fun grantCardValues(playerTurnGameState: PlayerTurnGameState): PlayerTurnGameState{
        return playerTurnGameState.copy(money = playerTurnGameState.money + additionalMoney,
                                        draws = playerTurnGameState.draws + additionalDraws,
                                        purchases = playerTurnGameState.purchases + additionalPurchases,
                                        actions = playerTurnGameState.actions + additionalActions)
    }

}
