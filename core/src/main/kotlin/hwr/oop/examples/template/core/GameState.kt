package hwr.oop.examples.template.core

data class GameState (private val id: Int,
                      private val playersCount: Int,
                      private val cardShop: CardShop = CardShop(listOf()),
                      private val players: List<Player> = listOf(),
                      private val currentPlayerIndex: Int = 0,
                      private val market: Int = 0) {

    //getter
    fun id():Int = id
    fun playersCount():Int = playersCount
    fun cardShop(): CardShop = cardShop
    fun players(): List<Player> = players
    fun currentPlayerIndex(): Int = currentPlayerIndex

    private fun change(id: Int = this.id,
               playersCount: Int = this.playersCount,
               cardShop: CardShop = this.cardShop,
               players: List<Player> = this.players,
               currentPlayerIndex: Int = this.currentPlayerIndex): GameState {
        return this.copy(
            id = id,
            playersCount = playersCount,
            cardShop = cardShop,
            players = players,
            currentPlayerIndex = currentPlayerIndex,
        )
    }
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

    fun buy(CardToBuy: CardID, playerIndex: Int): GameState {
//        if(!this.players[playerIndex].canBuy(CardToBuy)) {
//            return this
//        }
        val (newCardShop, success) = this.cardShop.takeCard(CardToBuy)
        if (!success) {
            return this
        }
//        val newPlayer = this.players[playerIndex].addToDiscard(CardToBuy)
//        val newPlayerList = this.players.mapIndexed {index, player -> if(index == playerIndex){newPlayer} else{player}}
        return this.change(cardShop = newCardShop)
    }
}
