package hwr.oop.examples.template.core

enum class Card (private val card: CardDefinition) {

    COPPER(Copper()),
    ESTATE(Estate());

    fun isPlayable(): Boolean {
        return card.types.contains(CardType.ACTION) ||
                card.types.contains(CardType.TREASURE)
    }

    fun play(currentStats: PlayerStats, currentCards: PlayerCards, state: GameState): PlayResult {
        val stats = applyStats(currentStats)
        val cardsAfterDraw = draw(currentCards)

        val context = GameContext(stats, consumeFrom(cardsAfterDraw), state)
        return card.action(context)
    }

    private fun consumeFrom(playerCards: PlayerCards): PlayerCards {
        val activeCards = playerCards.extractActiveCards()
        val cardsAfterConsuming = activeCards.consume(this)
        return cardsAfterConsuming.update(playerCards)
    }

    private fun applyStats(stats: PlayerStats): PlayerStats {
        return stats.change(card.actions, card.buys, card.gold)
    }

    private fun draw(currentCards: PlayerCards): PlayerCards{
        return currentCards.draw(card.draw)
    }

    fun cost() = card.cost

    fun unplayableErrorDescription(): String {
        check( !(isPlayable()) ) { "unplayable error only exists for playable cards" }

        return "only cards of types \"action\" and \"treasure\" may be played, actual types only include: " + card.types
    }

}