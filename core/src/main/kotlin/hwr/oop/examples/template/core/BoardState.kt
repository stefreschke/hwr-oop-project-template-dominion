package hwr.oop.examples.template.core

data class BoardState(val market: Market, val players: List<Player>){

    fun piles() = market.piles

    fun nextState(activePlayer: ActivePlayer): BoardState{
        return BoardState(market, players.drop(1) + activePlayer.endTurn())
    }

    fun nextPlayer(): Player {
        return players[0]
    }

    fun purchase(activePlayer: ActivePlayer, card: Card): Game {
        val result = market.purchase(activePlayer, card)
        val state = BoardState(result.market, players)
        return Game(GameStatus.Running, state, result.player)
    }
}
