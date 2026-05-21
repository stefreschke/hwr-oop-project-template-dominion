package hwr.oop.examples.template.core

data class ShopPile (private val toSell: CardID, private var remainingCards: Int) {

    fun toSell(): CardID = toSell
    fun remainingCards(): Int = remainingCards
    fun isEmpty(): Boolean = remainingCards == 0
    fun buy(): ShopPile = this.copy(remainingCards = remainingCards - 1)
}