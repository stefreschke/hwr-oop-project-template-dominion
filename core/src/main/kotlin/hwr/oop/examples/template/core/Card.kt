package hwr.oop.examples.template.core

data class Card(
    val type: CardType, //später mehrere Card Types?
    val name: String,
    val cost: Int = 0,
    val draw: Int = 0,
    val actions: Int = 0,
    val buys: Int = 0,
    val gold: Int = 0,
    val points: Int = 0)
