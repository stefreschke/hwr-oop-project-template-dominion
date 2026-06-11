package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameAPITest {

    val _freePile = Pile(Card.COPPER, 1)
    val _pile = Pile(Card.ESTATE, 1)
    val _market = Market(setOf(_freePile, _pile))
    val _game = Game(BoardState(_market, listOf(PlayerCards())), ActivePlayer())

    @Test
    fun `playing copper gives player gold`() {
        //when
        val result: Game = _game.play(Card.COPPER)
        //then
        assertThat(result.activePlayer.stats.money)
            .isEqualTo(1)
    }

    @Test
    fun `playing card removes it from active cards`() {
        //when
        val result = _game.play(Card.COPPER)
        //then
        assertThat(result.activePlayer.cards.hand)
            .doesNotContain(Card.COPPER)
    }

    @Test
    fun `purchased card is added to player cards`() {
        //given
        val getMoney1 = _game.play(Card.COPPER)
        val getMoney2 = getMoney1.play(Card.COPPER)
        val getMoney3 = getMoney2.play(Card.COPPER)
        //when
        val result = getMoney3.purchase(Card.ESTATE)
        val original = _game.activePlayer.cards.totalCopiesOf(Card.ESTATE)
        //then
        assertThat(result.activePlayer.cards.totalCopiesOf(Card.ESTATE))
            .isEqualTo(original + 1)
    }

    @Test
    fun `purchasing card reduces available money`() {
        //given
        val getMoney1 = _game.play(Card.COPPER)
        val getMoney2 = getMoney1.play(Card.COPPER)
        val getMoney3 = getMoney2.play(Card.COPPER)
        //when
        val result = getMoney3.purchase(Card.ESTATE)
        val startingMoney = getMoney3.activePlayer.stats.money
        //then
        assertThat(result.activePlayer.stats.money)
            .isEqualTo(startingMoney - Card.ESTATE.cost())
    }

    @Test
    fun `next switches active player`() {
        //when
        val next = _game.next()
        //then
        assertThat(next.activePlayer)
            .isNotEqualTo(_game.activePlayer)
    }

    @Test
    fun `next creates player with fresh turn stats`() {
        //when
        val next = _game.next()
        //then
        assertThat(next.activePlayer.stats.actions).isEqualTo(1)
        assertThat(next.activePlayer.stats.purchases).isEqualTo(1)
        assertThat(next.activePlayer.stats.money).isEqualTo(0)
    }

}