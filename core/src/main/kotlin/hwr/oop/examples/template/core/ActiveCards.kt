package hwr.oop.examples.template.core

class ActiveCards(private val hand: List<Card> = emptyList(), private val used: List<Card> = emptyList()) {
    fun playableCards(): List<Card> {
        return hand.filter { it.isPlayable() }
    }

    fun consume(card: Card): ActiveCards {
        if(hand.contains(card)) {
            return ActiveCards(removeCard(card), used + card)
        }

        return this
    }

    private fun removeCard(id: Card): List<Card> {
        val idx = hand.indexOf(id)
        return hand.take(idx) + hand.drop(idx + 1)
    }

    fun update(cycle: PlayerCards): PlayerCards {
        return cycle.insertTurnState(hand, used)
    }
}
