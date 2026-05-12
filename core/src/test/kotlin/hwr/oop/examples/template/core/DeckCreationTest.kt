package hwr.oop.examples.template.core

import hwr.oop.examples.template.core.card_definitions.Copper
import hwr.oop.examples.template.core.card_definitions.Estate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeckCreationTest {


//look into gamestate class for further info

//    @Test
//    fun `create starting Deck`() {
//        //given
//        var gameState = GameState(1, 3)
//
//        //when
//        gameState = gameState.innitNewGame()
//
//        //then
//        val expectedCardList : List<Card> =
//                List(7) { Copper() } +
//                List(3) { Estate() }
//
//        assertThat(gameState.id()).isEqualTo(1)
//        assertThat(gameState.players().size).isEqualTo(3)
//
//        for (player in gameState.players()) {
//            val deck = player.deck()
//            val cards = deck.cards()
//
//            assertThat(cards.map{ it::class })
//                .containsExactlyInAnyOrderElementsOf(
//                    expectedCardList.map{ it::class }
//                )
//        }
//    }
}