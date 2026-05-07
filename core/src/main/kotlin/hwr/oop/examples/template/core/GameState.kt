package hwr.oop.examples.template.core

class GameState (private val id: Int,
                 private val playersCount: Int,
                 private val players: List<Player> = listOf()) {

    //getter
    fun id():Int = id
    fun players(): List<Player> = players


    fun innitNewGame(): GameState {
        val startingDeck = Deck(listOf(Cards.COPPER,
            Cards.COPPER,
            Cards.COPPER,
            Cards.COPPER,
            Cards.COPPER,
            Cards.COPPER,
            Cards.COPPER,
            Cards.ESTATE,
            Cards.ESTATE,
            Cards.ESTATE))
        val players: List<Player> = when(this.playersCount) {
            1 -> TODO("error not implemented yet")
            2 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck))
            3 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck), Player("gamma", startingDeck))
            4 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck), Player("gamma", startingDeck), Player("delta", startingDeck))
            else -> TODO("error not implemented yet")
        }
        val newGame = GameState(this.id, this.playersCount, players = players)
        return newGame

    }
}
