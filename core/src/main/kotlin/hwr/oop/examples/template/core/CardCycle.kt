package hwr.oop.examples.template.core

class CardCycle(private val stock: List<CardID>, private val discard: List<CardID> = emptyList(), private val state: TurnState = TurnState()) {
    fun discard(): CardCycle{
        return CardCycle(stock, discard + state.discard(), TurnState())
    }

    fun draw(count: Int): CardCycle{
        val remaining: Int = stock.size - count
        val draw = stock.takeLast(count)
        if(remaining >= 0){
            val remainder = stock.take(remaining)
            return CardCycle(remainder, discard, state.draw(draw))
        }

        val missing = remaining * -1
        if(discard.size < missing){
            return CardCycle(emptyList(), emptyList(), state.draw(discard))
        } // this means the player has fewer cards then he is trying to draw which IS a valid case

        val refill = CardCycle(discard.shuffled(), emptyList(), state.draw(draw))
        return refill.draw(missing)
    }

    fun handSize() = state.handSize()
    fun stockSize() = stock.size
    fun discardSize() = discard.size


//    fun insert(cards: List<Card>): CardCycle{
//        return CardCycle(stock, discard + cards, hand)
//    } WAITING FOR TEST

}
