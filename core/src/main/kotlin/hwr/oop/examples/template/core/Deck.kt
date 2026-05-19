package hwr.oop.examples.template.core

class Deck (private val playerIndex: Int,
            private val cards: List<CardID> = listOf<CardID>()){

    fun cards(): List<CardID> = cards
}
