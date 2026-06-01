package hwr.oop.examples.template.core

enum class CardID (private val card: Card) {

    COPPER(Copper()),
    ESTATE(Estate());

    fun isPlayable(): Boolean {
        return card.types.contains(CardType.ACTION) ||
                card.types.contains(CardType.TRESSURE)
    }
}