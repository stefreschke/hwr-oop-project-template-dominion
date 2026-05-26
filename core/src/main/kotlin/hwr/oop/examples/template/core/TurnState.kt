package hwr.oop.examples.template.core

class TurnState(private val hand: List<CardID> = emptyList(), private val used: List<CardID> = emptyList()) {
    fun draw(draw: List<CardID>): TurnState {
        return TurnState(hand + draw, used)
    }

    fun discard(): List<CardID> {
        return hand + used
    }

    fun handSize() = hand.size

}
