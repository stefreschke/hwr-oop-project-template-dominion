package hwr.oop.examples.template.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required

class MakeChoiceCommand : CliktCommand(name = "makeChoice") {
	private val gameId by requireObject<String>()
	private val playerId by option("--player-id", help = "The ID of the player submitting the choice.").required()
	private val selectedOptions by option(
		"--selected-option",
		help = "An option to select (card name or option label). Pass multiple times for multi-select choices. Omit entirely to select nothing."
	).multiple()
	
	override fun run(): Unit = TODO()
}
