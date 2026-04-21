package hwr.oop.examples.template.service

import hwr.oop.examples.template.service.api.GameActionApi
import hwr.oop.examples.template.service.api.GameApi
import hwr.oop.examples.template.service.model.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller : GameApi, GameActionApi {
	override fun getGame(gameId: String?): ResponseEntity<GameState> {
		TODO("Not yet implemented")
	}
	
	override fun startGame(startGameRequest: @Valid StartGameRequest?): ResponseEntity<GameCreatedResponse> {
		TODO("Not yet implemented")
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
