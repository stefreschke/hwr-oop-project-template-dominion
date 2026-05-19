package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HandTest {

    @Test
    fun `discard Hand`() {
        //given
        val gameState = GameState(1, 3)
        val gameStateInnitialized = gameState.innitNewGame()
        //when
        val newPlayer = gameStateInnitialized.players()[2].copy(
            hand = Hand(2 ,listOf(CardID.COPPER, CardID.ESTATE))
        )
        val gameStateToTest = gameStateInnitialized.copy(
            players = gameStateInnitialized.players().subList(0, 2) + listOf<Player>(newPlayer)
        )
        val resultGameState = gameStateToTest.players()[2].hand().discard(gameStateToTest)
        //then
        assertThat(resultGameState.players()[2].hand().cards()).isEqualTo(listOf<CardID>())
        assertThat(resultGameState.players()[2].discard().cards).isEqualTo(listOf(CardID.COPPER, CardID.ESTATE))
    }
}