package hwr.oop.examples.template.core

data class Player(private val name: String,
                  private val index: Int,
                  private val deck: Deck = Deck(index),
                  private val hand: Hand = Hand(index),
                  private val discard: Discard = Discard(index),
                  private val remainingBuys: Int = 1,
                  private val remainingActions: Int  = 1,
                  private val currentGold: Int = 0,
                  private val currentPhase: Int = 0,
) {
    //getter
    fun name(): String = name
    fun deck(): Deck = deck
    fun hand(): Hand = hand
    fun discard(): Discard = discard
    fun remainingBuys(): Int = remainingBuys
    fun remainingActions(): Int = remainingActions
    fun currentGold(): Int = currentGold
    fun currentPhase(): Int = currentPhase
    fun index(): Int = index
}
