package hwr.oop.examples.template.core

class Market(private val piles: Set<Pile>, private val emptyPiles: Int = 0) {
    fun emptyPiles(required: Int) = emptyPiles >= required

    fun purchase(activePlayer: ActivePlayer, card: CardID): PurchaseResult {
        val pile = piles.find { it.isType(card) }
        if(pile == null){
            return PurchaseResult.Failure("no such pile")
        }

        if(activePlayer.canAfford(card.cost())){
            return draw(pile, activePlayer)
        }

        return PurchaseResult.Failure("not enough money")
    }

    private fun draw(pile: Pile, activePlayer: ActivePlayer): PurchaseResult {
        val pileAfterDraw = pile.draw()
        if(pileAfterDraw.isEmpty()){
            return PurchaseResult.Success(removePile(pile), activePlayer.purchase(pile.card))
        }

        return PurchaseResult.Success(replacePile(pile, pileAfterDraw), activePlayer.purchase(pile.card))
    }

    private fun removePile(pile: Pile): Market{
        return Market(piles - pile, emptyPiles + 1)
    }

    private fun replacePile(pile: Pile, newPile: Pile): Market{
        return Market(piles - pile + newPile)
    }
}