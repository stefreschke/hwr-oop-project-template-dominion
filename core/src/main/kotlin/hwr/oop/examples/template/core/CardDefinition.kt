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

    fun beginAction(context: GameContext): PlayResult {
        return PlayResult.WaitingForChoice(Card.byName(name), emptyMap())
    }

    fun endAction(context: GameContext, choices: Map<String, List<AnsweredChoice>>): PlayResult.Complete {
        val state = context.state()
        val player = context.player()
        return PlayResult.Complete(state, player)
    }
}
