package hwr.oop.examples.template.service

import hwr.oop.examples.template.core.DominionPersistence
import hwr.oop.examples.template.core.GameInstance
import hwr.oop.examples.template.core.Pile
import hwr.oop.examples.template.core.Player
import hwr.oop.examples.template.service.api.GameActionApi
import hwr.oop.examples.template.service.api.GameApi
import hwr.oop.examples.template.service.model.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import kotlin.contracts.Effect

@RestController
class Controller(
	val persistence: DominionPersistence
) : GameApi, GameActionApi {

	override fun getGame(gameId: String?): ResponseEntity<GameState> {
		if (gameId == null) {
			throw IllegalArgumentException("Game ID is required")
		}

		val game = persistence.load(gameId)
		return ResponseEntity.ok(map(game))
	}

	private fun map(game: GameInstance): GameState {
		//String status, String currentPlayerId, String currentPhase, Integer actionsRemaining, Integer buysRemaining, Integer coinsAvailable, List<@Valid SupplyPile> supply, List<@Valid PlayerState> players, List<@Valid ActiveEffect> effectStack) {
		return GameState(game.status(), game.currentPlayerId(), game.currentPhase(), game.actionsRemaining(), game.buysRemaining(), game.coinsAvailable(), supplies(game.supply()), players(game.players()), effects())
	}

	private fun supplies(piles: Set<Pile>): List<SupplyPile> {
		return piles.map{ SupplyPile(it.name(), it.count()) }
	}

	private fun players(players: List<Player>): List<PlayerState> {
		return players.map { PlayerState(it.id(), it.hand(), it.playArea(), it.discard(), it.deckSize()) }
	}

	private fun effects(): List<ActiveEffect> {
		return emptyList()
	}

	override fun startGame(startGameRequest: @Valid StartGameRequest?): ResponseEntity<GameCreatedResponse> {
		val players = startGameRequest?.playerIds
		val kingdomCards = startGameRequest?.kingdomCards

		val game = GameInstance.create(players!!.toList(), kingdomCards!!.toList())
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
