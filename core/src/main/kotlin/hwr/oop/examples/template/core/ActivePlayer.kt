package hwr.oop.examples.template.core

private val initialStats = Stats(1, 1, 0)

class ActivePlayer(
    private val player: Player,
    internal val stats: Stats = initialStats)
{
    fun actions() = stats.actions
    fun purchases() = stats.purchases
    fun coins() = stats.money

    fun id() = player.id

    fun play(card: Card, game: GameState): PlayResult {
        if(card.isPlayable()) {
            return card.play(player, stats, game)
        }

        throw UnplayableCardException(card)
    }

    fun canAfford(cost: Int) = stats.money > cost

    fun purchase(card: Card): ActivePlayer {
        val cost = card.cost()
        if(canAfford(cost)){
            return ActivePlayer(player.insert(card), stats.change(0, -1, -cost))
        }

        return this
    }

    fun endTurn(): Player {
        return player.endTurn()
    }

}