package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeckCreationTest {

    @Test
    fun `create starting Deck`() {
        //given
        var gameState = GameState(1, 3)
        gameState = gameState.innitNewGame()

        //then
        assertThat(gameState.id()).isEqualTo(1)
        assertThat(gameState.players()).isNotEqualTo(1)
        assertThat(gameState.players()).isNotEqualTo(5)
        for (player in gameState.players()) {
            assertThat(player.deck().cards()).containsExactlyInAnyOrder(
                Cards.COPPER,
                Cards.COPPER,
                Cards.COPPER,
                Cards.COPPER,
                Cards.COPPER,
                Cards.COPPER,
                Cards.COPPER,
                Cards.ESTATE,
                Cards.ESTATE,
                Cards.ESTATE
            )
        }
    }
}