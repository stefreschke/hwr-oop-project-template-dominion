package hwr.oop.examples.template.core

data class Pile(val card: Card, private val quantity: Int){
    fun draw(): Pile = copy(quantity = quantity - 1)
    fun isEmpty() = quantity == 0
    fun isType(other: Card) = other == card

    override fun equals(other: Any?): Boolean {
        return other is Pile && card == other.card
    }

    override fun hashCode(): Int {
        return card.hashCode()
    }

}
