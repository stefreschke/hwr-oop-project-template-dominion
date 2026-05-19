package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayerTest {

	@Test
	fun `create a new Player`() {
		//given
		val player = Player("alpha", 1, Deck(1,listOf(CardID.COPPER)))
		//when
		val name = player.name()
		val remainingBuys = player.remainingBuys()
		val remainingActions = player.remainingActions()
		val currentGold = player.currentGold()
		val currentPhase = player.currentPhase()
		//then
		assertThat(name).isEqualTo("alpha")
		assertThat(remainingBuys).isEqualTo(1)
		assertThat(remainingActions).isEqualTo(1)
		assertThat(currentGold).isEqualTo(0)
		assertThat(currentPhase).isEqualTo(0)
	}
}