package hwr.oop.examples.template.core

interface DominionPersistence {
    fun load(gameId: String): GameInstance
    fun save(game: GameInstance)
}