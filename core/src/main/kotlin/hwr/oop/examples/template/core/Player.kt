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
        return Player(id, cards.endTurn())
    }

    fun use(card: Card): Player {
        val activeCards = cards.extractActiveCards()
        val cardsAfterConsuming = activeCards.use(card)
        return Player(id, cardsAfterConsuming.update(cards))
    }

    fun cards() = cards.extractActiveCards()

    fun hand(): List<String> {

    }

    fun playArea(): List<String> {

    }

    fun discard(): List<String>{

    }

    fun deckSize(): Int {

    }

}
