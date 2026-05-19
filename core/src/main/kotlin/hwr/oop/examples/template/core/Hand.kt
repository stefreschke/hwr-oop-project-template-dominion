package hwr.oop.examples.template.core

class Hand (private val playerIndex: Int,
            private val cards: List<CardID> = listOf<CardID>()) {

    fun cards(): List<CardID> = cards


    fun discard(gameState: GameState): GameState{
        val changedPlayer = gameState.players()[this.playerIndex].copy(
            hand = Hand(this.playerIndex),
            discard = Discard(this.playerIndex, gameState.players()[this.playerIndex].discard().cards() + this.cards),
        )

        val newPlayers = gameState.players().subList(0, this.playerIndex) + changedPlayer + gameState.players().subList(this.playerIndex + 1, gameState.players().size)

        return gameState.copy(
            players = newPlayers
        )
    }
}