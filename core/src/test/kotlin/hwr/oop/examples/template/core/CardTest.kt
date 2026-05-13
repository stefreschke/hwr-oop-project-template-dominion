package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CardTest {

	val initialState = PlayerTurnGameState(0, 0, 0, 0, 0)

	@Test
	fun `create a cards effect`() {
		//given
		val draws = 1
		val money = 2
		val purchases = 3
		val actions = 4

		val cardEffect = object : PlayableCardEffect {
			override val additionalDraws: Int = draws
			override val additionalMoney: Int = money
			override val additionalPurchases: Int = purchases
			override val additionalActions: Int = actions

			override fun apply(playerTurnGameState: PlayerTurnGameState): PlayerTurnGameState {
				return grantCardValues(playerTurnGameState)
			}
		}

		//when
		val resultState = cardEffect.apply(initialState)
		//result:
		val resultStateMoney = resultState.money
		val resultStatePoints = resultState.winningPoints
		val resultStateDraws = resultState.draws
		val resultStatPurchases = resultState.purchases
		val resultStatActions = resultState.actions

		//then
		assertThat(resultStateMoney).isEqualTo(money)
		assertThat(resultStatePoints).isEqualTo(0)
		assertThat(resultStateDraws).isEqualTo(draws)
		assertThat(resultStatPurchases).isEqualTo(purchases)
		assertThat(resultStatActions).isEqualTo(actions)
	}

	@Test
	fun `create a card`() {
		//given

		val card = object : Card  {
			override val name: String = "New Card"
			override val cost: Int = 42
			override val cardEffect: CardEffect
				get() = error("irrelevant")
		}

		//when
		val name = card.name
		val cost = card.cost

		//then
		assertThat(name).isEqualTo("New Card")
		assertThat(cost).isEqualTo(42)
		assertThrows<IllegalStateException> {
			card.applyEffect(initialState)
		}

	}
}