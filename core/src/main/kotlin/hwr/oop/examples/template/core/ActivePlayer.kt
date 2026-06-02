package hwr.oop.examples.template.core

private val initialStats = PlayerStats(1, 1, 0)

class ActivePlayer(
    internal val cards: PlayerCards = PlayerCards(),
    internal val stats: PlayerStats = initialStats)
{
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
            return ActivePlayer(cards.insert(card), stats.change(0, -1, -cost))
        }

        return this
    }

    fun endTurn(): PlayerCards {
        return cards.endTurn()
    }

}