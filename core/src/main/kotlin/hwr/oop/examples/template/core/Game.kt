package hwr.oop.examples.template.core

class Game(private val state: GameState, internal val activePlayer: ActivePlayer) {

    fun piles() = state.piles()

    fun next(): Game{
        return Game(state.nextState(activePlayer), initPlayer(state.nextPlayer()))
    }

    private fun initPlayer(player: Player): ActivePlayer {
        return ActivePlayer(player)
    }

    fun play(card: Card): Game {
        val result = activePlayer.play(card, state)
        return Game(result.state, result.activePlayer)
    }

    fun purchase(card: Card): Game{
        return state.purchase(activePlayer, card)
    }

}