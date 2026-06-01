package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardTest {

    @Test
    fun createCardTest(){
        //given
        val card = object: Card{
            override val types: List<CardType> = listOf(CardType.TRESSURE)
            override val name: String = "Card"
            override val cost: Int = 3

            override val draw: Int = 0
            override val actions: Int = 2
            override val buys: Int = 0

            override val gold: Int = 0
            override val points: Int = 0
        }

        //
        val name = card.name
        val cost = card.cost
        val additionalActions = card.actions
        val additionalPurchases = card.buys
        val additionalMoney = card.gold
        val additionalPoints = card.points
        //then
        assertThat(name).isEqualTo("Card")
        assertThat(cost).isEqualTo(3)
        assertThat(additionalActions).isEqualTo(2)
        assertThat(additionalPurchases).isEqualTo(0)
        assertThat(additionalMoney).isEqualTo(0)
        assertThat(additionalPoints).isEqualTo(0)
    }

}