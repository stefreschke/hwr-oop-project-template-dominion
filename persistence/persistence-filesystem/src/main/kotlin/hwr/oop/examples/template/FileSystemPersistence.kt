package hwr.oop.examples.template

import hwr.oop.examples.template.core.DominionPersistence
import hwr.oop.examples.template.core.GameInstance
import okio.FileSystem

class FileSystemPersistence(
	configuration: FileSystemPersistenceConfiguration,
	private val fileSystem: FileSystem = FileSystem.SYSTEM,
) : DominionPersistence{

	private val directory = configuration.directory

	override fun load(gameId: String): GameInstance {
		TODO("Not yet implemented")
	}

	override fun save(game: GameInstance) {
		TODO("Not yet implemented")
	}
}

