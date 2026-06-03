package hwr.oop.examples.template.core

data class GameState(val market: Market, val players: List<Player>){

    fun piles() = market.piles

    fun nextState(activePlayer: ActivePlayer): GameState{
        return GameState(market, players.drop(1) + activePlayer.endTurn())
    }

    fun nextPlayer(): Player {
        return players[0]
    }

    fun purchase(activePlayer: ActivePlayer, card: Card): Game {
        val result = market.purchase(activePlayer, card)
        val state = GameState(result.market, players)
        return Game(state, result.player)
    }
}
