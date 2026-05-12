package hwr.oop.examples.template.core

import hwr.oop.examples.template.core.card_definitions.Copper
import hwr.oop.examples.template.core.card_definitions.Estate

//currently incompatible with playerTurnGameState,
// I would make deck a separate class playerTurnHand or similar
// player would preferably contain all data which needs to be stored only BETWEEN turns
// if player would contain smth like ownedCards, then when it's a players turn the activeHand could be generated from that

//class GameState (private val id: Int,
//                 private val playersCount: Int,
//                 private val players: List<Player> = listOf()) {
//
//    //getter
//    fun id():Int = id
//    fun players(): List<Player> = players
//
//    fun innitNewGame(): GameState {
//        val startingDeck = Deck(
//            List(7) { Copper() } +
//                    List(3) { Estate() }
//        )
//
//        val players: List<Player> = when(this.playersCount) {
//            2 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck))
//            3 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck), Player("gamma", startingDeck))
//            4 -> listOf(Player("alpha", startingDeck), Player("beta", startingDeck), Player("gamma", startingDeck), Player("delta", startingDeck))
//            else -> throw IllegalArgumentException("game only possible with 2-4 players")
//        }
//        return GameState(this.id, this.playersCount, players = players)
//    }
//}
