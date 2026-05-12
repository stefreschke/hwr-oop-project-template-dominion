package hwr.oop.examples.template.core

interface CardEffect {
    fun apply(playerTurnGameState: PlayerTurnGameState): PlayerTurnGameState
}
