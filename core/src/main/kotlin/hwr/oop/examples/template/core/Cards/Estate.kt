package hwr.oop.examples.template.core

class Estate(
    override val type: CardType = CardType.POINTS,
    override val name: String = "estate",
    override val cost: Int = 2,
    override val draw: Int = 0,
    override val actions: Int = 0,
    override val buys: Int = 0,
    override val gold: Int = 0,
    override val points: Int = 1
) : Card {
    override fun specialTextApplication(gameState: GameState): GameState = gameState
}