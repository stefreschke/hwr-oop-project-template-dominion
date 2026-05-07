package hwr.oop.examples.template.core

class Player(private val name: String,
             private val deck: Deck,
             private val remainingBuys: Int = 1,
             private val remainingActions: Int  = 1,
             private val currentGold: Int = 0,
             private val currentPhase: Int = 0,
) {
    //getter
    fun name(): String = name
    fun deck(): Deck = deck
    fun remainingBuys(): Int = remainingBuys
    fun remainingActions(): Int = remainingActions
    fun currentGold(): Int = currentGold
    fun currentPhase(): Int = currentPhase
}
