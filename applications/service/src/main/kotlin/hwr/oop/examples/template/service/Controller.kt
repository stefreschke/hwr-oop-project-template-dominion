package hwr.oop.examples.template.service

import hwr.oop.examples.template.core.DominionPersistence
import hwr.oop.examples.template.core.GameInstance
import hwr.oop.examples.template.service.api.GameActionApi
import hwr.oop.examples.template.service.api.GameApi
import hwr.oop.examples.template.service.model.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
	val persistence: DominionPersistence
) : GameApi, GameActionApi {

	override fun getGame(gameId: String?): ResponseEntity<GameState> {
		if(gameId == null) {
			return ResponseEntity.notFound().build()
		}

		val game = persistence.load(gameId)
		return ResponseEntity.ok(map(game))
	}

	private fun map(game: GameInstance): GameState {
		return GameState()
	}

	override fun startGame(startGameRequest: @Valid StartGameRequest?): ResponseEntity<GameCreatedResponse> {
		val game = GameInstance()
		persistence.save(game)
		return ResponseEntity.ok(GameCreatedResponse(game.id))
	}
	
	override fun buyCard(
		gameId: String?,
		buyCardsRequest: @Valid BuyCardsRequest?,
	): ResponseEntity<GameState> {
		TODO("Not yet implemented")
	}
	
	override fun getChoices(gameId: String?): ResponseEntity<PendingChoicesResponse> {
		TODO("Not yet implemented")
	}
	
	override fun makeChoice(
		gameId: String?,
		makeChoiceRequest: @Valid MakeChoiceRequest?,
	): ResponseEntity<GameState> {
		TODO("Not yet implemented")
	}
	
	override fun playAction(
		gameId: String?,
		playActionRequest: @Valid PlayActionRequest?,
	): ResponseEntity<GameState> {
		TODO("Not yet implemented")
	}
	
	override fun playTreasures(
		gameId: String?,
		playTreasuresRequest: @Valid PlayTreasuresRequest?,
	): ResponseEntity<GameState> {
		TODO("Not yet implemented")
	}
	
}
