package hwr.oop.examples.template.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required

class PlayActionCommand : CliktCommand(name = "playAction") {
	private val gameId by requireObject<String>()
	private val playerId by option("--player-id", help = "The ID of the player playing the action card.").required()
	private val cardName by option("--card-name", help = "The name of the action card to play from hand.").required()
	
	override fun run(): Unit = TODO()
}
