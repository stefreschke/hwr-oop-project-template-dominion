package hwr.oop.examples.template.core

class Market(internal val piles: Set<Pile>, private val emptyPiles: Int = 0) {
    fun emptyPiles(required: Int) = emptyPiles >= required

    fun piles(predicate: (Card) -> Boolean) = piles.filter{ predicate(it.card) }

    fun purchase(activePlayer: ActivePlayer, card: Card): PurchaseResult {
        val pile = piles.find { it.isType(card) }
        if(pile == null){
            throw PurchaseException("no such pile")
        }

        if(activePlayer.canAfford(card.cost())){
            val playerAfterDraw = activePlayer.purchase(pile.card)
            return PurchaseResult(draw(pile), playerAfterDraw)
        }

        throw PurchaseException("not enough money")
    }

    fun draw(pile: Pile): Market {
        val pileAfterDraw = pile.draw()

        if(pileAfterDraw.isEmpty()){
            return removePile(pile)
        }

        return replacePile(pile, pileAfterDraw)
    }

    private fun removePile(pile: Pile): Market{
        return Market(piles - pile, emptyPiles + 1)
    }

    private fun replacePile(pile: Pile, newPile: Pile): Market {
        return Market(piles - pile + newPile)
    }
}