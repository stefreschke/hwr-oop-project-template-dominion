package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TurnOrderTest {
    @ParameterizedTest
    @CsvSource(value = [
        "0, 1",
        "1, 2",
        "2, 0"
    ])
    fun `turn can pass to next player`(indexToTest: Int, expectedResult: Int) {
        //given
        val gameState = GameState(1, 3, currentPlayerIndex = indexToTest)
        //when
        val newGameState = gameState.passTurn()
        //then
        assertThat(newGameState.currentPlayerIndex()).isEqualTo(expectedResult)
    }
}