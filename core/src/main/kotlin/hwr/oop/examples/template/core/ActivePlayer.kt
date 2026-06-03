package hwr.oop.examples.template.core

private val initialStats = Stats(1, 1, 0)

class ActivePlayer(
    internal val player: Player,
    internal val stats: Stats = initialStats)
{
    fun actions() = stats.actions
    fun purchases() = stats.purchases
    fun coins() = stats.money

    fun id() = player.id

    fun play(card: Card, game: GameState): PlayResult {
        if(player.holds(card)) {
            return card.play(player, stats, game)
        }

        throw CardNotInHandException(card)
    }

    fun canAfford(cost: Int) = stats.money > cost

    fun purchase(card: Card): ActivePlayer {
        if(canAfford(card.cost())){
            return ActivePlayer(player.insert(card), stats.change(0, -1, -card.cost()))
        }

        throw PurchaseException("not enough money")
    }

    fun endTurn(): Player {
        return player.endTurn()
    }

}