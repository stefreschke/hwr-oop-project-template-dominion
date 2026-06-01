package hwr.oop.examples.template.core

class Game(private val market: Market, private val activePlayer: ActivePlayer, private val inactivePlayers: List<PlayerCards>) {

    fun next(): Game{
        return Game(market, player(inactivePlayers.first()), inactivePlayers.drop(1) + activePlayer.end())
    }

    private fun player(cards: PlayerCards): ActivePlayer {
        return ActivePlayer(1, 1, 0, cards)
    }

    fun play(card: CardID): Game {
        return when(val result = activePlayer.play(card, inactivePlayers)) {
            is PlayResult.Success -> {
                Game(market, result.activePlayer, result.players)
            }

            is PlayResult.Failure -> {
                throw UnplayableCardException(card)
            }
        }
    }

    fun purchase(card: CardID): Game{
        return when(val result = market.purchase(activePlayer, card)){
            is PurchaseResult.Success -> {
                Game(result.market, result.player, inactivePlayers)
            }

            is PurchaseResult.Failure -> {
                throw PurchaseException(result.reason)
            }

            else -> throw IllegalArgumentException("result unsupported")
        }
    }

    private class UnplayableCardException(card: CardID) : Exception(card.unplayableErrorDescription())
    private class PurchaseException(message: String): Exception(message)

}