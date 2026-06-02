package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MarketPurchaseTest {

    val _player = ActivePlayer()
    val _richPlayer = ActivePlayer(PlayerCards(), PlayerStats(1, 1, 10))

    @Test
    fun `returns only piles matching predicate`() {
        val market = Market(
            setOf(
                Pile(Card.COPPER, 10),
                Pile(Card.ESTATE, 10)
            )
        )

        val result = market.piles { it == Card.COPPER }

        assertThat(result)
            .hasSize(1)
            .allMatch { it.card == Card.COPPER }
    }

    @Test
    fun `cannot purchase card without pile`() {
        val market = Market(emptySet())

        assertThatThrownBy {
            market.purchase(_player, Card.COPPER)
        }
            .isInstanceOf(PurchaseException::class.java)
            .hasMessageContaining("no such pile")
    }

    @Test
    fun `cannot purchase card without money`() {
        //given
        val pile = Pile(Card.ESTATE, 0)
        val market = Market(setOf(pile))
        //then
        assertThatThrownBy {
            market.purchase(_player, Card.ESTATE)
        }
            .isInstanceOf(PurchaseException::class.java)
            .hasMessageContaining("not enough money")
    }

    @Test
    fun `purchase draws one card from pile`() {
        //given
        val pile = Pile(Card.ESTATE, 5)
        val market = Market(setOf(pile))
        //when
        val result = market.purchase(_richPlayer, Card.ESTATE)

        val updatedPile =
            result.market.piles { it == Card.ESTATE }.single()

        //then
        assertThat(updatedPile.quantity).isEqualTo(4)
    }

    @Test
    fun `empty pile is removed from market`() {
        //given
        val pile = Pile(Card.ESTATE, 1)
        val market = Market(setOf(pile))
        //when
        val result = market.draw(pile)
        //then
        assertThat(result.piles { true })
            .isEmpty()
    }

    @Test
    fun `removing pile increases empty pile count`() {
        val pile = Pile(Card.ESTATE, 1)
        val market = Market(setOf(pile))

        val result = market.draw(pile)

        assertThat(result.emptyPiles(1)).isTrue()
    }

}