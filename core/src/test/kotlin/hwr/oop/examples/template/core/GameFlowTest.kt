package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameFlowTest {

    @Test
    fun `initializing players turn state`(){
        //given
        val playerState = PlayerTurnGameState(0, 0, 0, 0, 0)

        //when
        val money = playerState.money
        val points = playerState.winningPoints
        val draws = playerState.draws
        val purchases = playerState.purchases
        val actions = playerState.actions
        //... further stats?

        //then
        assertThat(money).isEqualTo(0)
        assertThat(points).isEqualTo(0)
        assertThat(draws).isEqualTo(0)
        assertThat(purchases).isEqualTo(0)
        assertThat(actions).isEqualTo(0)
    }
}