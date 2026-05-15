package hwr.oop.examples.template.core

interface Card {
    val type: CardType
    val name: String
    val cost: Int
    val draw: Int
    val actions: Int
    val buys: Int
    val gold: Int
    val points: Int

    fun specialTextApplication(gameState: GameState): GameState
}