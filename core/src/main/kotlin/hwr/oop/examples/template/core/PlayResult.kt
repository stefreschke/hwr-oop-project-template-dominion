package hwr.oop.examples.template.core

sealed interface PlayResult {
    data class Success(val activePlayer: ActivePlayer, val players: List<PlayerCards>) : PlayResult
    data object Failure : PlayResult
}