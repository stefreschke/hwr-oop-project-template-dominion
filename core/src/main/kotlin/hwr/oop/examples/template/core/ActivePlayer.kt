package hwr.oop.examples.template.core

class ActivePlayer(
    private val actions: Int,
    private val purchases: Int,
    private val money: Int,
    private val cards: PlayerCards = PlayerCards())
    : PurchaseResult
{
    fun canDoAction() = actions > 0
    fun canDoPurchase() = purchases > 0

    fun play(card: CardID, players: List<PlayerCards>): PlayResult {
        if(card.isPlayable()) {
            return playCard(card, players)
        }

        return PlayResult.Failure
    }

    private fun playCard(card: CardID, players: List<PlayerCards>): PlayResult {
        val activeCards = cards.extractActiveCards()
        val playState = activeCards.play(card)
        val player = ActivePlayer(actions - 1, purchases, money, playState.update(cards))
        return PlayResult.Success(player, players)
    }

    fun canAfford(cost: Int) = money > cost

    fun purchase(card: CardID): ActivePlayer {
        val cost = card.cost()
        if(canAfford(cost)){
            return ActivePlayer(actions, purchases - 1, money - cost, cards.insert(card))
        }

        return this
    }

    fun end(): PlayerCards {
        return cards.discard()
    }
}