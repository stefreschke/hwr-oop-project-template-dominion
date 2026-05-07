package hwr.oop.examples.template.core

class GameState (private val id: Int,
                 private val playersCount: Int,
                 private val players: List<Player> = listOf()) {

    //getter
    fun id():Int = id
    fun players(): List<Player> = players


    fun innitNewGame(): GameState {
        val startingDeck = Deck(
            List(7) { Cards.COPPER } +
                    List(3) { Cards.ESTATE }
        )
        val players: List<Player> = when(this.playersCount) {
            2 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck))
            3 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck), Player("gamma", startingDeck))
            4 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck), Player("gamma", startingDeck), Player("delta", startingDeck))
            else -> throw IllegalArgumentException("game only possible with 2-4 players")
        }
        return GameState(this.id, this.playersCount, players = players)
    }
}
