package hwr.oop.examples.template.core

class GameContext(
    private val player: Player,
    val stats: Stats,
    val state: GameState
) {

    fun player() = player

}
