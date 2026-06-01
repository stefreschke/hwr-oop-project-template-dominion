package hwr.oop.examples.template.core

class CardCycle(private val stock: List<CardID>, private val discard: List<CardID> = emptyList(), private val hand: List<CardID> = emptyList(), private val used: List<CardID> = emptyList()) {
    fun discard(): CardCycle {
        return CardCycle(stock, discardedCards())
    }

    private fun discardedCards() = discard + hand + used

    fun draw(count: Int): CardCycle {
        val remaining: Int = stock.size - count
        val drawn = stock.takeLast(count)
        if (remaining >= 0) {
            return drawFromStock(drawn, remaining)
        }

        val missing = remaining * -1
        if (discard.size < missing) {
            return drawAsManyAsPossible(drawn)
        } // this means the player has fewer cards then he is trying to draw which IS a valid case

        return reshuffleAndDraw(drawn, missing)
    }

    private fun drawnCards(drawn: List<CardID>) = hand + drawn

    private fun drawFromStock(drawn: List<CardID>, remaining: Int): CardCycle {
        val remainder = stock.take(remaining)
        return CardCycle(remainder, discard, drawnCards(drawn), used)
    }

    private fun drawAsManyAsPossible(drawn: List<CardID>): CardCycle {
        return CardCycle(emptyList(), emptyList(), drawnCards(drawn) + discard, used)
    }

    private fun reshuffleAndDraw(drawn: List<CardID>, missing: Int): CardCycle{
        val refill = CardCycle(discard.shuffled(), emptyList(), drawnCards(drawn))
        return refill.draw(missing)
    }

    fun state() = TurnState(hand, used)
    fun insertTurnState(hand: List<CardID>, used: List<CardID>): CardCycle {
        return CardCycle(stock, discard, hand, used)
    }

   fun insert(card: CardID): CardCycle {
       return CardCycle(stock, discard + card, hand)
   }

    fun handSize() = hand.size
    fun usedSize() = used.size
    fun stockSize() = stock.size
    fun discardSize() = discard.size

}
