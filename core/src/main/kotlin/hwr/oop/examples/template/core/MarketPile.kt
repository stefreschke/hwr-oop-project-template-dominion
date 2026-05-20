package hwr.oop.examples.template.core

class MarketPile (private val toSell: CardID, private var remainingCards: Int) {

    fun toSell(): CardID = toSell
    fun remainingCards(): Int = remainingCards

    fun buyCard(gameSate: GameState): GameState{
        val remainingCards = (gameSate.)
        return gameSate
    }
}