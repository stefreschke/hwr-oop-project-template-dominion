package hwr.oop.examples.template.core

interface CardDefinition {
    val types: List<CardType>
    val name: String
    val cost: Int
    val draw: Int
    val actions: Int
    val buys: Int
    val gold: Int
    val points: Int

    fun action(context: GameContext): PlayResult{
        val state = context.state
        val player = context.player()
        return PlayResult(state, player)
    }
}
