package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class MarketPurchaseTest {
    val _freeCard = Card.COPPER
    val _card = Card.ESTATE
    val _quantity = 1

    val _piles = setOf(Pile(_freeCard, _quantity), Pile(_card, _quantity))
    val _market = Market(_piles)

    val _money = 3
    val _playerWithMoney = ActivePlayer(1, 1, _money)
    val _playerWithoutMoney = ActivePlayer(0, 0, 0)

    @Test
    fun `successful purchase`(){
        //given
        val result = successPurchase(_playerWithMoney, _card)
        //when
        val market = result.market
        val player = result.player
        //then
        assertThat(_playerWithMoney.canDoPurchase()).isTrue()
        assertThat(player.canDoPurchase()).isFalse()
        assertThat(_market.emptyPiles(1)).isFalse()
        assertThat(market.emptyPiles(1)).isTrue()
    }

    @Test
    fun `player doesnt lose money when buying free card`() {
        //given

        //val re
    }

    @Test
    fun `player without money can buy free card`() {
        //given
        val result = successPurchase(_playerWithoutMoney, _freeCard)
        //when
        val player = result.player
        val market = result.market
        //then
        assertThat(_playerWithoutMoney.canDoPurchase()).isFalse()

    }

    @Test
    fun `a a`(){
        //given
        val result = _market.purchase(_playerWithMoney, _card)
        //when
        val success = result as PurchaseResult.Success
        val market = success.market
        val player = success.player
        //then
        assertThat(player.canDoPurchase()).isFalse()
    }

    fun successPurchase(player: ActivePlayer, card: Card): PurchaseResult.Success {
        val result = _market.purchase(player, card)
        if(result is PurchaseResult.Success) {
            return result
        }

        fail("purchase was no success")
    }

}