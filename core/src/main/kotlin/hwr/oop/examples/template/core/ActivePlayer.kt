package hwr.oop.examples.template.core

class ActivePlayer(
    private val stats: PlayerStats,
    private val cards: PlayerCards = PlayerCards()) {
    fun canDoAction() = stats.actions > 0
    fun canDoPurchase() = stats.purchases > 0

    fun play(card: Card, game: GameState): PlayResult {
        if(card.isPlayable()) {
            return card.play(stats, cards, game)
        }

        throw UnplayableCardException(card)
    }

    fun canAfford(cost: Int) = stats.money > cost

    fun purchase(card: Card): ActivePlayer {
        val cost = card.cost()
        if(canAfford(cost)){
            return ActivePlayer(stats.change(0, -1, -cost), cards.insert(card))
        }

        return this
    }

    fun end(): PlayerCards {
        return cards.discard()
    }

}