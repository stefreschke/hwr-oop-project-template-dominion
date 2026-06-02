package hwr.oop.examples.template.core

data class CardShop (private val piles: List<ShopPile>) {

    fun piles(): List<ShopPile> = piles

    fun pileFromId(cardToSearch: CardID): ShopPile {
        for (pile in piles) {
            if (pile.toSell() == cardToSearch) {
                return pile
            }
        }
        throw IllegalArgumentException("No pile with ID $cardToSearch")
    }
    fun containsPile(cardToSearch: CardID): Boolean{
        try {pileFromId(cardToSearch)}
        catch (e: IllegalArgumentException){
            return false
        }
        return true
    }


    fun takeCard(cardToBuy: CardID): Pair<CardShop, Boolean> {
        if(!containsPile(cardToBuy)){
            return Pair(this, false)
        }
        val currentPile = this.pileFromId(cardToBuy)
        if (currentPile.isEmpty()){
            return Pair(this, false)
        }
        val newPile = currentPile.buy()
        val newCardShop = this.copy(
            piles = this.piles - currentPile + newPile
        )
        return Pair(newCardShop, true)
    }

}