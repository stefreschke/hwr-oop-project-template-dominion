package hwr.oop.examples.template.core


class BaseCard(
    val cardEffects: CardEffects) {
    private fun applyCardStats(context: GameContext): GameContext {
        val result = context.applyCardStats(cardEffects)
        return result
    }

    fun execute(context: GameContext): GameContext {
        return applyCardStats(context)
    }
}
