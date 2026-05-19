package hwr.oop.examples.template.core

data class GameState (private val id: Int,
                 private val playersCount: Int,
                 private val players: List<Player> = listOf(),
                 private val currentPlayerIndex: Int = 0) {

    //getter
    fun id():Int = id
    fun players(): List<Player> = players
    fun playersCount():Int = playersCount
    fun currentPlayerIndex(): Int = currentPlayerIndex

    fun innitNewGame(): GameState {

        val startingDeck = List(7) { CardID.COPPER } + List(3) { CardID.ESTATE }

        val players: List<Player> = when(this.playersCount) {
            2 -> listOf(Player("alpha", 0, Deck(0, startingDeck)), Player("beta", 1, Deck(1, startingDeck)))
            3 -> listOf(Player("alpha", 0, Deck(0, startingDeck)), Player(
                "beta",
                1,
                Deck(1, startingDeck)
            ), Player("gamma", 2, Deck(2, startingDeck)))
            4 -> listOf(Player("alpha", 0, Deck(0, startingDeck)), Player(
                "beta",
                1,
                Deck(1, startingDeck)
            ), Player("gamma", 2, Deck(2, startingDeck)), Player("delta", 3, Deck(3, startingDeck)))
            else -> throw IllegalArgumentException("game only possible with 2-4 players")
        }
        return GameState(this.id, this.playersCount, players = players)
    }

    fun passTurn(): GameState {
        return this.copy(currentPlayerIndex = (this.currentPlayerIndex + 1) % this.playersCount)
    }
}
