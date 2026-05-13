package hwr.oop.examples.template.core

class Card(private val type: CardType, //später mehrere Card Types?
           private val name: String,
           private val cost: Int = 0,
           private val draw: Int = 0,
           private val actions: Int = 0,
           private val buys: Int = 0,
           private val gold: Int = 0,
           private val points: Int = 0) {

    //getter
    fun type():CardType = type
    fun cost():Int = cost
    fun draw():Int = draw
    fun actions():Int = actions
    fun buys():Int = buys
    fun gold():Int = gold
    fun points():Int = points
}
