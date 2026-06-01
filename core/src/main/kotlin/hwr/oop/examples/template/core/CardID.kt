package hwr.oop.examples.template.core

enum class CardID (private val card: Card) {

    COPPER(Copper()),
    ESTATE(Estate());

    fun isPlayable(): Boolean {
        return card.types.contains(CardType.ACTION) ||
                card.types.contains(CardType.TRESSURE)
    }

    fun cost() = card.cost

    fun unplayableErrorDescription(): String {
        if(isPlayable()){
            throw IllegalStateException("unplayable error only exists for unplayable cards")
        }

        return "only cards of types \"action\" and \"treasure\" may be played, actual types only include: " + card.types
    }
}