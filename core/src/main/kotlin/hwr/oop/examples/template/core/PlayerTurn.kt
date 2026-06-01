package hwr.oop.examples.template.core

class PlayerTurn(private val actions: Int, private val purchases: Int, private val money: Int, private val cycle: CardCycle) {
    fun canDoAction() = actions > 0
    fun canDoPurchase() = purchases > 0

    fun play(card: CardID): PlayerTurn {
        if(card.isPlayable()) {
            val state = cycle.state()
            val playState = state.play(card)
            return PlayerTurn(actions - 1, purchases, money, playState.update(cycle))
        }

        return this
    }

    fun canAfford(cost: Int) = cost > money

    fun purchase(card: CardID, cost: Int): PlayerTurn {
        if(canAfford(cost)){
            return PlayerTurn(actions, purchases - 1, money - cost, cycle.insert(card))
        }

        return this
    }
}