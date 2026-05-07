package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardTest {

	@Test
	fun `create a new card`() {
		//given
		val actionCard = Card(CardType.ACTION, "Village", 3, 1, 2, 0, 0, 0)
		//when
		val type = actionCard.type()
		val cost = actionCard.cost()
		val draw = actionCard.draw()
		val actions = actionCard.actions()
		val buys = actionCard.buys()
		val gold = actionCard.gold()
		val points = actionCard.points()
		val compare = CardType.ACTION
		//then
		assertThat(type).isEqualTo(CardType.ACTION)
		assertThat(cost).isEqualTo(3)
		assertThat(draw).isEqualTo(1)
		assertThat(actions).isEqualTo(2)
		assertThat(buys).isEqualTo(0)
		assertThat(gold).isEqualTo(0)
		assertThat(points).isEqualTo(0)

	}

	@Test
	fun `tressure card creation`() {
		//given
		val copperCard = Card(CardType.TRESSURE, "Copper", gold = 1)
		//when
		val type = copperCard.type()
		val gold = copperCard.gold()
		//then
		assertThat(type).isEqualTo(CardType.TRESSURE)
		assertThat(gold).isEqualTo(1)
	}
}