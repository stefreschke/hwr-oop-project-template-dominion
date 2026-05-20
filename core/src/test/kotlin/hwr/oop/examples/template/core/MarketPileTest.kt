package hwr.oop.examples.template.core
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarketPileTest {
    @Test
    fun marketPileTest() {
        //given
        var CardStack = MarketPile(CardID.COPPER, 5)
        //when
        var remainingCards = CardStack.remainingCards()
        //then
        assertThat(remainingCards).isPositive()

    }
}
