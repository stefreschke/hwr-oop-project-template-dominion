package hwr.oop.examples.template.core

enum class CardsDefinition (private val card: Card) {

    COPPER(Card(CardType.TRESSURE, "Copper", gold = 1)),
    ESTATE(Card(CardType.POINTS, "Estate", cost = 2, points = 1)),
    VILLAGE(Card(CardType.ACTION, "Village", cost = 3, actions = 2, draw = 1)),
}