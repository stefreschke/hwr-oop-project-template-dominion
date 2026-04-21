package hwr.oop.examples.template.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required

class BuyCardsCommand : CliktCommand(name = "buyCards") {
	private val gameId by requireObject<String>()
	private val playerId by option("--player-id", help = "The ID of the player buying the cards.").required()
	private val cardsToBuy by option(
		"--card-name",
		help = "Name of a card to buy from the supply. Pass multiple times to buy several cards in order. Omit entirely to forfeit remaining buys."
	).multiple()
	
	override fun run(): Unit = TODO()
}
