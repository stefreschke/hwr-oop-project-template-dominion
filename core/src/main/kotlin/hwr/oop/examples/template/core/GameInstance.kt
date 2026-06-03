package hwr.oop.examples.template.core

import java.util.UUID

class GameInstance(private val game: Game) {
    val id: String = UUID.randomUUID().toString()

    fun status(): String {
        TODO("Not yet implemented")
    }

    fun currentPlayerId(): String {
        return game.activePlayer.id()
    }

    fun currentPhase(): String {
        TODO("Not yet implemented")
    }

    fun actionsRemaining(): Int {
        return game.activePlayer.actions()
    }

    fun buysRemaining(): Int {
        return game.activePlayer.purchases()
    }

    fun coinsAvailable(): Int {
        return game.activePlayer.coins()
    }

    fun supply(): Set<Pile> {
        return game.
    }

     fun players(): List<Player> {
        TODO("Not yet implemented")
    }

    fun effects() {
        TODO("Not yet implemented")
    }

    companion object{
        fun create(
            players: List<String>,
            kingdomCards: List<String>
        ): GameInstance {
            val players = players.map { Player(it, PlayerCards()) }
            val market = createMarket(kingdomCards)
            val state = GameState(market, players.drop(1))
            val game = Game(state, ActivePlayer(players[0]))
            return GameInstance(game)
        }

        private fun createMarket(kingdomCards: List<String>): Market {
            return Market(emptySet())
        }

    }

}
