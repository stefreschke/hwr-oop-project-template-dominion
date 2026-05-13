package hwr.oop.examples.template.core

interface ResourceCardEffect: CardEffect {
    val type: ResourceCardResourceType
    val value: Int

    fun applyResource(playerTurnGameState: PlayerTurnGameState): PlayerTurnGameState{
        return when(type){
            ResourceCardResourceType.Treasure -> playerTurnGameState.copy(money = playerTurnGameState.money + value)
            ResourceCardResourceType.WinningPoints -> playerTurnGameState.copy(winningPoints = playerTurnGameState.winningPoints + value)
        }
    }

}
