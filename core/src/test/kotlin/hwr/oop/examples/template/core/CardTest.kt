package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardTest {

    @Test
    fun createCardTest(){
        //given
        val card = object: Card{
            override val name: String = "Card"
            override val cost: Int = 3

            override val actions: Int = 2
            override val purchases: Int = 0

            override val money: Int = 0
            override val points: Int = 0
        }
        //
        val name = card.name
        val cost = card.cost
        val additionalActions = card.actions
        val additionalPurchases = card.purchases
        val additionalMoney = card.money
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