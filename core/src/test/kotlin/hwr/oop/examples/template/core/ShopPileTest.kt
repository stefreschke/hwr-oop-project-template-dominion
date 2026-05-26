package hwr.oop.examples.template.core
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShopPileTest {
    @Test
    fun  `shopPile test`() {
        //given
        var CardStack = ShopPile(CardID.COPPER, 5)
        //when
        var remainingCards = CardStack.remainingCards()
        //then
        assertThat(remainingCards).isPositive()

    }

    @Test
    fun `Shop innit Tets`() {
        //given
        val shop = CardShop(listOf(ShopPile(CardID.COPPER, 50)))
        //when
        val piles = shop.piles()
        val contentOfPile = shop.piles()[0].toSell()
        val amountOfPile = shop.piles()[0].remainingCards()
        //then
        assertThat(piles).isNotEmpty()
        assertThat(contentOfPile).isEqualTo(CardID.COPPER)
        assertThat(amountOfPile).isEqualTo(50)

    }

    @Test
    fun `Buying a Card reduces Cards in a pile`() {
        //given
        val shop = CardShop(listOf(ShopPile(CardID.COPPER, 50)))
        val gameState = GameState(0, 2, cardShop = shop)
        //when
        val newGameState = gameState.buy(CardID.COPPER)
        //then
        assertThat(newGameState.cardShop().pileFromId(CardID.COPPER).remainingCards()).isEqualTo(49)
    }

    @Test
    fun `buying a non existing card doesnt do anything`() {
        //given
        val shop = CardShop(listOf(ShopPile(CardID.COPPER, 50)))
        val gameState = GameState(0, 2, cardShop = shop)
        //when
        val newGameState = gameState.buy(CardID.ESTATE)
        //then
        assertThat(newGameState).isEqualTo(gameState)
        assertThat(newGameState.cardShop().pileFromId(CardID.COPPER).remainingCards()).isEqualTo(50)

    }
}
