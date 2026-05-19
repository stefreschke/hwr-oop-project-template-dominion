package hwr.oop.examples.template.core

class Market (private val toSell: CardID, private val remainingCards: Int) {

    fun toSell(): CardID = toSell
    fun remainingCards(): Int = remainingCards

    fun buyCard(gameSate: GameState): GameState{

        return gameSate
    }
}