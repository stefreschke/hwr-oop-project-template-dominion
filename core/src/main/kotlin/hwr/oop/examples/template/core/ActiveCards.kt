package hwr.oop.examples.template.core

class ActiveCards(val hand: List<CardID> = emptyList(), val used: List<CardID> = emptyList()) {
    fun playableCards(): List<CardID> {
        return hand.filter { it.isPlayable() }
    }

    fun play(id: CardID): ActiveCards {
        if(hand.contains(id)) {
            return ActiveCards(removeCard(id), used + id)
        }

        return this
    }

    private fun removeCard(id: CardID): List<CardID> {
        val idx = hand.indexOf(id)
        return hand.take(idx) + hand.drop(idx + 1)
    }

    fun update(cycle: PlayerCards): PlayerCards {
        return cycle.insertTurnState(hand, used)
    }
}
