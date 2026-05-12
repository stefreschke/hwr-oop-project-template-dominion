package hwr.oop.examples.template.core

interface Card{
    val name: String
    val cost : Int
    val cardEffect: CardEffect

    fun applyEffect(playerTurnGameState: PlayerTurnGameState) : PlayerTurnGameState{
        return cardEffect.apply(playerTurnGameState)
    }
}