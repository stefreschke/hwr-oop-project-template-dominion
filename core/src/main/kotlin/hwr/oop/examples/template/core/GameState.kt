package hwr.oop.examples.template.core

data class GameState (private val id: Int,
                 private val playersCount: Int,
                 private val players: List<Player> = listOf(),
                 private val currentPlayerIndex: Int = 0, private val market: Int = 0) {

    //getter
    fun id():Int = id
    fun players(): List<Player> = players
    fun playersCount():Int = playersCount
    fun currentPlayerIndex(): Int = currentPlayerIndex

    fun innitNewGame(): GameState {
        val startingDeck = List(7) { CardID.COPPER } + List(3) { CardID.ESTATE }

        val playerA = Player("alpha", 0, Deck(0, startingDeck))
        val playerB = Player("beta", 1, Deck(1, startingDeck))
        val playerC = Player("gamma", 2, Deck(2, startingDeck))
        val playerD = Player("delta", 3, Deck(3, startingDeck))

        val players: List<Player> = when(this.playersCount) {
            2 -> listOf(playerA, playerB)
            3 -> listOf(playerA, playerB, playerC)
            4 -> listOf(playerA, playerB, playerD, playerD)
            else -> throw IllegalArgumentException("game only possible with 2-4 players")
        }
        return GameState(this.id, this.playersCount, players)
    }

    fun passTurn(): GameState {
        return this.copy(currentPlayerIndex = (this.currentPlayerIndex + 1) % this.playersCount)
    }
}
