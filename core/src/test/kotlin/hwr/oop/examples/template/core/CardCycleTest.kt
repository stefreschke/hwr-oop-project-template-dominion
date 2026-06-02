package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardCycleTest {

    private val _copperCount = 4
    private val _estateCount = 3
    private val _totalCount = _copperCount + _estateCount

    private val _items: List<Card> = List(_copperCount){Card.COPPER} + List(_estateCount){Card.ESTATE}
    private val _cycle = PlayerCards(_items)

    @Test
    fun drawTest() {
        //given
        val count = 5
        //when
        val draw = _cycle.draw(count)
        val hand = draw.handSize()
        val discardResult = draw.discard()
        val discardSize = discardResult.discardSize()
        val stockSize = discardResult.stockSize()
        //then
        assertThat(hand).isEqualTo(count)
        assertThat(discardSize).isEqualTo(count)
        assertThat(stockSize).isEqualTo(_totalCount - count)
    }

    @Test
    fun `drawing more than available results in all available`(){
        //given
        val count = _totalCount + 1
        //when
        val draw = _cycle.draw(count)
        val stockSize = draw.stockSize()
        val handSize = draw.handSize()
        //then
        val availableCount = _cycle.stockSize() + _cycle.discardSize()
        assertThat(stockSize).isEqualTo(0)
        assertThat(handSize).isEqualTo(availableCount)
    }

    @Test
    fun `drawing with less then asked in stock shuffles discard`(){
        //given
        val emptyStock = _cycle.draw(_totalCount)
        val discard = emptyStock.discard()
        val count = 1
        //when
        val draw = discard.draw(count)
        val handSize = draw.handSize()
        val stockSize = draw.stockSize()
        val discardSize = draw.discardSize()
        //then
        assertThat(handSize).isEqualTo(count)
        assertThat(stockSize).isEqualTo(_totalCount - count)
        assertThat(discardSize).isEqualTo(0)
    }

    @Test
    fun discardTest(){
        //given
        val emptyStock = _cycle.draw(_totalCount)
        val discard = emptyStock.discard()
        //when
        val handSize = discard.handSize()
        val usedSize = discard.usedSize()
        val discardSize = discard.discardSize()
        //then
        assertThat(handSize).isEqualTo(0)
        assertThat(usedSize).isEqualTo(0)
        assertThat(discardSize).isEqualTo(_totalCount)
    }
}