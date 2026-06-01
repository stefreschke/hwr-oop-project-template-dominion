package hwr.oop.examples.template.core

class TurnState(val hand: List<CardID> = emptyList(), val used: List<CardID> = emptyList()) {
    fun playableCards(): List<CardID> {
        return hand.filter { it.isPlayable() }
    }

    fun play(id: CardID): TurnState {
        if(hand.contains(id)) {
            return TurnState(removeCard(id), used + id)
        }

        return this
    }

    private fun removeCard(id: CardID): List<CardID> {
        val idx = hand.indexOf(id)
        return hand.take(idx) + hand.drop(idx + 1)
    }

    fun update(cycle: CardCycle): CardCycle {
        return cycle.insertTurnState(hand, used)
    }
}
