package hwr.oop.examples.template.core

class Game(private val state: GameState, private val activePlayer: ActivePlayer) {

    private val initialStats = PlayerStats(1, 1, 0)

    fun next(): Game{
        return Game(state.nextState(activePlayer), initPlayer(state.nextPlayer()))
    }

    private fun initPlayer(cards: PlayerCards): ActivePlayer {
        return ActivePlayer(initialStats, cards)
    }

    fun play(card: Card): Game {
        val result = activePlayer.play(card, state)
        return Game(result.state, result.activePlayer)
    }

    fun purchase(card: Card): Game{
        return state.purchase(activePlayer, card)
    }

}