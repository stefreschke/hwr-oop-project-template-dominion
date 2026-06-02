package hwr.oop.examples.template.core

class GameContext(
    private val stats: PlayerStats,
    private val cards: PlayerCards,
    val state: GameState
) {

    fun player() = ActivePlayer(stats, cards)

}
