package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarketPurchaseTest {
    val _freeCard = CardID.COPPER
    val _card = CardID.ESTATE
    val _quantity = 1

    val _piles = setOf(Pile(_freeCard, _quantity), Pile(_card, _quantity))
    val _market = Market(_piles)

    val _money = 3
    val _playerWithMoney = ActivePlayer(1, 1, _money)
    val _player = ActivePlayer(0, 0, 0)

    @Test
    fun `successful purchase`(){
        //given
        val player = _player.purchase(_card)
        //then
        assertThat(player.canDoPurchase()).isFalse()
    }

    @Test
    fun ``(){

    }

}