package hwr.oop.examples.template.core

class Discard (private val playerIndex: Int,
               val cards: List<CardID> = listOf<CardID>()) {

    fun cards(): List<CardID> = cards
}