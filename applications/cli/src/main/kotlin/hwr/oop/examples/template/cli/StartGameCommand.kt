package hwr.oop.examples.template.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option

class StartGameCommand : CliktCommand(name = "startGame") {
	private val playerIds by option(
		"--player-id",
		help = "ID of a player joining the game. Pass multiple times for each player (2–4 total)."
	).multiple(required = true)
	
	private val kingdomCards by option(
		"--kingdom-card",
		help = "Name of a kingdom card to include in the supply. Pass exactly 10 times."
	).multiple(required = true)
	
	override fun run(): Unit = TODO()
}
