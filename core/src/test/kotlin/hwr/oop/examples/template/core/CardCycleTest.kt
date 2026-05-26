package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardCycleTest {

    @Test
    fun cardCycleTest() {
        //given
        val items: List<CardID> = List(4){CardID.COPPER} + List(3){CardID.ESTATE}
        val cycle = CardCycle(items)

        //when
        val count = 5
        val draw = cycle.draw(count)
        val hand = draw.handSize()
        val discardResult = draw.discard()
        val dSize = discardResult.discardSize()
        val sSize = discardResult.stockSize()

        //then
        assertThat(hand).isEqualTo(count)
        assertThat(dSize).isEqualTo(count)
        assertThat(sSize).isEqualTo(7 - count)
    }

}