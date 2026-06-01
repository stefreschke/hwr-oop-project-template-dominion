package hwr.oop.examples.template.core

data class Pile(val card: CardID, val quantity: Int){
    fun draw(): Pile = copy(quantity = quantity - 1)
    fun isEmpty() = quantity == 0
    fun isType(other: CardID) = other == card
}
