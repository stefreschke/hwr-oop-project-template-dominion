package hwr.oop.examples.template.core

class Copper: CardDefinition {
    override val types: List<CardType> = listOf(CardType.TRESSURE)
    override val name: String = "copper"
    override val cost: Int = 0
    override val draw: Int = 0
    override val actions: Int = 0
    override val buys: Int = 0
    override val gold: Int = 1
    override val points: Int = 0

    //override fun specialTextApplication(gameState: GameState): GameState = gameState
}