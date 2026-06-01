package hwr.oop.examples.template.core

class ActivePlayer(private val actions: Int, private val purchases: Int, private val money: Int, private val cycle: CardCycle) {
    fun canDoAction() = actions > 0
    fun canDoPurchase() = purchases > 0

    fun play(card: CardID): ActivePlayer {
        if(card.isPlayable()) {
            val state = cycle.extractActiveCards()
            val playState = state.play(card)
            return ActivePlayer(actions - 1, purchases, money, playState.update(cycle))
        }

        return this
    }

    fun canAfford(cost: Int) = cost > money

    fun purchase(card: CardID, cost: Int): ActivePlayer {
        if(canAfford(cost)){
            return ActivePlayer(actions, purchases - 1, money - cost, cycle.insert(card))
        }

        return this
    }
}