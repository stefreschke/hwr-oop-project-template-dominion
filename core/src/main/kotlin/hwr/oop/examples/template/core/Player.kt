package hwr.oop.examples.template.core

data class Player(internal val id: String, internal val cards: PlayerCards){

    fun id() = id

    fun insert(card: Card): Player {
        return Player(id, cards.insert(card))
    }

    fun draw(count: Int): Player {
        return Player(id, cards.draw(count))
    }

    fun endTurn(): Player {
        return Player(id, cards.discard())
    }

    fun use(card: Card): Player {
        return Player(id, cards.use(card))
    }

    fun hand(): List<Card> {
        return cards.hand
    }

    fun playArea(): List<String> {
        return emptyList()
    }

    fun discard(): List<Card> {
        return cards.discard
    }

    fun deckSize(): Int {
        return cards.stockSize() + cards.discardSize() + cards.handSize() + cards.usedSize()
    }

    fun holds(card: Card): Boolean {
        return cards.inHand(card)
    }

}
