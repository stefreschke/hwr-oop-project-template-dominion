package hwr.oop.examples.template.core

enum class CardsDefinition (private val card: CardClass) {

    COPPER(CardClass(CardType.TRESSURE, "Copper", gold = 1)),
    ESTATE(CardClass(CardType.POINTS, "Estate", cost = 2, points = 1)),
    VILLAGE(CardClass(CardType.ACTION, "Village", cost = 3, actions = 2, draw = 1)),
}